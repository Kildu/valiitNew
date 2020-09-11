package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BankController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static Map<String, Integer> ALL_ACCOUNTS = new HashMap<>();         //peab ära kaduma, kui teen SQL kaudu

    @PostMapping("sqlaccounts")
    public void createSqlAccount(@RequestBody BankAccountsDTO accounts) {
        String sql = "INSERT INTO account (id, account_nr, balance, client_id) values (:id, :account_nr, :balance, :client_id)";    //koolon viitab väljapoole SQL'i, viitab Javale
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", accounts.getId());
        paramMap.put("account_nr", accounts.getAccountNr());
        paramMap.put("balance", accounts.getBalance());
        paramMap.put("client_id", accounts.getClientId());
        jdbcTemplate.update(sql, paramMap);
    } // web:   http://localhost:8080/sqlaccounts

    @GetMapping("sqlaccounts/{accountNo}")
    public String getSqlAccount(@PathVariable("accountNo") String accountNr) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        String result = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return result;
    } // web:   http://localhost:8080/sqlaccounts/EE4

    @GetMapping("sqlaccounts")
    public List<BankAccountsDTO> getAllSqlAccount() {
        String sql = "SELECT * FROM account";         // WHERE id = :id";
        List <BankAccountsDTO> resultList = jdbcTemplate.query(sql, new AccountRowMapper());
        return resultList;
    } // web:   http://localhost:8080/sqlaccounts/EE4




    @PutMapping("sqlaccounts/{accountNo}")
    public void depositSqlMoney(@RequestBody int deposit,
                                @PathVariable("accountNo") String accountNr) {
        String temp = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        int saldo = jdbcTemplate.queryForObject(temp, paramMap, int.class); // ....class määrab output format'i

        String sql = "UPDATE account SET balance = :balance where account_nr = :account_nr";
        paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        paramMap.put("balance", saldo + deposit);
        jdbcTemplate.update(sql, paramMap);
    } // web:   http://localhost:8080/sqlaccounts/EE4

    @PutMapping("sqlaccounts/wd/{accountN}")
    public void withdrawSqlMoney(@RequestBody int wdAmount,
                                 @PathVariable("accountN") String accountNr) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        int saldo = jdbcTemplate.queryForObject(sql, paramMap, int.class);

        sql = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        paramMap.put("balance", saldo - wdAmount);
        jdbcTemplate.update(sql, paramMap);
    } // web:   http://localhost:8080/sqlaccounts/wd/EE4

    @PutMapping("sqlaccounts/tran/{Account1}/{Account2}")
    public void transferSqlMoney(@RequestBody int amount,
                                 @PathVariable("Account1") String sender,
                                 @PathVariable("Account2") String receiver) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", sender);
        int saldoS = jdbcTemplate.queryForObject(sql, paramMap, int.class);

        sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        paramMap = new HashMap<>();
        paramMap.put("account_nr", receiver);
        int saldoR = jdbcTemplate.queryForObject(sql, paramMap, int.class);

        sql = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        paramMap = new HashMap<>();
        paramMap.put("account_nr", sender);
        paramMap.put("balance", saldoS - amount);
        jdbcTemplate.update(sql, paramMap);

        sql = "UPDATE account SET balance = :balance WHERE account_nr = :account_nr";
        paramMap = new HashMap<>();
        paramMap.put("account_nr", receiver);
        paramMap.put("balance", saldoR + amount);
        jdbcTemplate.update(sql, paramMap);
    }   // web: http://localhost:8080/sqlaccounts/tran/EE2/EE4


    @GetMapping("sqltest")
    public String testSql() {
        String sql = "SELECT account_nr FROM account WHERE id = :id";  // <-- ParamMap value läheb siia
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", 1);                //see value läheb WHERE :id
        String vastus = jdbcTemplate.queryForObject(sql, paramMap, String.class);

        //  2. näide: kutsume välja asja, mis ei tagasta midagi --> update, insert, delete
        sql = "UPDATE account SET balance = :balance where id = :id";
        paramMap = new HashMap<>();
        paramMap.put("balance", 50);
        paramMap.put("id", 3);
        jdbcTemplate.update(sql, paramMap);

        return vastus;
    } // web: http://localhost:8080/sqltest         -->POSTMANi


    @PostMapping("accounts")
    public void createAccount(@RequestBody BankAccountsDTO accounts) {
        ALL_ACCOUNTS.put(accounts.getAccountNr(), accounts.getBalance());
    } // web:   http://localhost:8080/accounts

    @GetMapping("accounts/{accountNo}")
    public int getAccount(@PathVariable("accountNo") String accountNr) {
        return ALL_ACCOUNTS.get(accountNr);
    }

    @GetMapping("accounts")         //Display all accounts
    public Map<String, Integer> bankAccounts() {
        return ALL_ACCOUNTS;
    }

    @PutMapping("accounts/{accountNo}")
    public void depositMoney(@RequestBody BankAccountsDTO accounts, @PathVariable("accountNo") String accountNr) {  //int
        //sisend kontonr ja balance
        //võtan mapist sellele kontole vastava balance'i, edasi liidan uue, mille sisestasin
        // kirjutan väärtuse map's üle
        int temp = ALL_ACCOUNTS.get(accountNr);
        ALL_ACCOUNTS.put(accounts.getAccountNr(), (accounts.getBalance() + temp));     //return
    }

    @PutMapping("accounts/wd/{accountN}")
    public void withdrawMoney(@RequestBody BankAccountsDTO accounts, @PathVariable("accountN") String accountNr) {  //int
        int temp = ALL_ACCOUNTS.get(accountNr);
        ALL_ACCOUNTS.put(accounts.getAccountNr(), (temp - accounts.getBalance()));  //return
    }

    @PutMapping("accounts/tr") // slash lõpus mõjutab????
    public void transferMoney(@RequestBody List<BankAccountsDTO> accounts) {        //PathVariable ei kasuta siin --> , List<BankAccountsDTO> accounts

//        @RequestParam("accountN1") String accountNr1,
//        @RequestParam("accountN2") String accountNr2
        //@RequestParam("accountN2") String accountNr2          // ....KUIDAS SAAN OBJEKTIDE LISTIST ANDMED KÄTTE!!!!!!!!!!.....
        String firstAccountNr = accounts.get(0).getAccountNr();  //1) küsin listilt indeksi järgi esimese objekt; 2) küsin objektilt kontonr
        int temp1 = ALL_ACCOUNTS.get(firstAccountNr);           //Saan 1. konto algseisu
        String secondAccountNr = accounts.get(1).getAccountNr();
        int temp2 = ALL_ACCOUNTS.get(secondAccountNr);          //2. konto algseis

        int newSum1 = temp1 - accounts.get(0).getBalance();
        ALL_ACCOUNTS.put(firstAccountNr, newSum1);     //võtan 1. kontolt raha maha
        ALL_ACCOUNTS.put(secondAccountNr, (accounts.get(1).getBalance() + temp2));       //lisan 2. kontole raha
    }   // web: http://localhost:8080/accounts/tr


    //TENNO MEETOD
    @PutMapping("accounts/tran/{Account1}/{Account2}")
    public void transferMoney(@RequestBody int amount,
                              @PathVariable("Account1") String sender,
                              @PathVariable("Account2") String receiver) {

        int temp1 = ALL_ACCOUNTS.get(sender);     //1.konto algseis
        int temp2 = ALL_ACCOUNTS.get(receiver);     //2.konto algseis

        ALL_ACCOUNTS.put(sender, temp1 - amount);     //võtan 1. kontolt raha maha
        ALL_ACCOUNTS.put(receiver, (temp2 + amount));       //lisan 2. kontole raha
    }   // web: http://localhost:8080/accounts/tran/EE1/EE2
}

//NÄIDE!
//bankAccounts2.put(requestBody.getAccountNr(),requestBody);
//bankAccounts2.get(requestBody.getAccountNr());
