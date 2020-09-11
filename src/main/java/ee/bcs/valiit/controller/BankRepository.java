package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createNewClientSql(String firstName, String lastName, String username, String password) {
        String sql = "INSERT INTO client (first_name, last_name, user_name, password) values (:firstName, :lastName, :username, :password)";    //koolon viitab väljapoole SQL'i, viitab Javale
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstName", firstName);
        paramMap.put("lastName", lastName);
        paramMap.put("username", username);
        paramMap.put("password", password);
        jdbcTemplate.update(sql, paramMap);
    }

    public int getClientId() {
        String sql = "SELECT max(id) FROM client";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void createNewAccount(String accountNo, int balance, int clientId) {
        String sql = "INSERT INTO account (account_nr, balance, client_id) VALUES (:account_nr, :balance, :client_id)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNo);
        paramMap.put("balance", balance);
        paramMap.put("client_id", clientId);
        jdbcTemplate.update(sql, paramMap);
    }

    public int getBalanceSql(String fromAcount) {
        String sql = "Select balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", fromAcount);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public List<BankAccountsDTO> getAllAccounts() {
        String sql = "SELECT * FROM account";
        List<BankAccountsDTO> resultList = jdbcTemplate.query(sql, new AccountRowMapper());
        return resultList;
    }

    public int updateBalanceSql(String accountNo, int balance) {
        String sql = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNo);
        paramMap.put("balance", balance);
        return jdbcTemplate.update(sql, paramMap);
    }

    public void addDepositToTransferList(int amount, String accountNr) {
        String sql = "INSERT INTO transfer_list (amount, type, id_to_account) values (:amount, :type, :toAccountId)";
        Map<String, Object> paramMap = new HashMap<>();
        //paramMap.put("toAccount", toAccount);
        paramMap.put("amount", amount);
        paramMap.put("type", "deposit");
        paramMap.put("toAccountId", getAccountId(accountNr));
        jdbcTemplate.update(sql, paramMap);
    }

    public void addWithdrawalToTransferList(int amount, String accountNr) {
        String sql = "INSERT INTO transfer_list (amount, type, id_from_account) values (:amount, :type, :fromAccountId)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("amount", amount);
        paramMap.put("type", "withdrawal");
        paramMap.put("fromAccountId", getAccountId(accountNr));
        jdbcTemplate.update(sql, paramMap);
    }

    public int getAccountId(String fromAcount) {
        String sql = "Select id FROM account WHERE account_nr = :account_nr";       //võtsin maha client_id ja jätsin id
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", fromAcount);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }
}
