package ee.bcs.valiit.controller;

import org.apache.tomcat.util.codec.binary.BaseNCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;      //seon BankService klassi BankRepository klassiga

    public int createNewClient(String firstName, String lastName, String username, String password) {
        bankRepository.createNewClientSql(firstName, lastName, username, password);
        return bankRepository.getClientId();
    }

    public void createNewAccount(String accountNo, int balance, int clientId) {
        bankRepository.createNewAccount(accountNo, balance, clientId);
    }

    public int getAccount(@PathVariable("accountNo") String accountNr) {
        int balance = bankRepository.getBalanceSql(accountNr);
        return balance;
    }

    public List<BankAccountsDTO> getAllSqlAccounts() {
        return bankRepository.getAllAccounts();
    }

    public void depositMoney(int deposit, String accountNr) {
        int balance = bankRepository.getBalanceSql(accountNr);
        int newBalance = balance + deposit;
        bankRepository.updateBalanceSql(accountNr, newBalance);
        bankRepository.addDepositToTransferList(deposit, accountNr);
    }

    public void withdrawSqlMoney(int wdAmount, String accountNr) {
        int balance = bankRepository.getBalanceSql(accountNr);
        int newBalance = balance - wdAmount;
        bankRepository.updateBalanceSql(accountNr, newBalance);
        bankRepository.addWithdrawalToTransferList(wdAmount, accountNr);
    }

    public void transferMoney(String fromAccount, String toAccount, int transferAmount) {
        int fromBalance = bankRepository.getBalanceSql(fromAccount);
        if (fromBalance >= transferAmount) {
            int toBalance = bankRepository.getBalanceSql(toAccount);
            bankRepository.updateBalanceSql(fromAccount, fromBalance - transferAmount);
            bankRepository.updateBalanceSql(toAccount, toBalance + transferAmount);
            bankRepository.addWithdrawalToTransferList(transferAmount, fromAccount);
            bankRepository.addDepositToTransferList(transferAmount, toAccount);
        }
    }
}
