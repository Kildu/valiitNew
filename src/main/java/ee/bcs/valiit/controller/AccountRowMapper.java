package ee.bcs.valiit.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<BankAccountsDTO> {
    @Override
    public BankAccountsDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        BankAccountsDTO bankAccounts = new BankAccountsDTO();
        bankAccounts.setId(resultSet.getInt("id"));
        bankAccounts.setAccountNr(resultSet.getString("account_nr"));
        bankAccounts.setBalance(resultSet.getInt("balance"));
        bankAccounts.setClientId(resultSet.getInt("client_id"));
        return bankAccounts;
    }
}
