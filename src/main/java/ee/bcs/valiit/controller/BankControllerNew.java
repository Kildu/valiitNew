package ee.bcs.valiit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankControllerNew {

    @Autowired BankService bankService;

    @PostMapping("bankservice/client")
    public ClientIdDTO createSqlClient(@RequestBody ClientDTO clients) {
        ClientIdDTO clientIdDTO = new ClientIdDTO();
        return clientIdDTO.setId(bankService.createNewClient(clients.getFirstName(), clients.getLastName(), clients.getUsername(), clients.getPassword()));
    } // web:   http://localhost:8080/bankservice/client

    @PostMapping("bankservice")
    public void createSqlAccount(@RequestBody BankAccountsDTO accounts) {
        bankService.createNewAccount(accounts.getAccountNr(), accounts.getBalance(), accounts.getClientId());
    } // web:   http://localhost:8080/bankservice

    @GetMapping("bankservice/{accountNo}")
    public BalanceDTO getSqlAccount(@PathVariable("accountNo") String accountNr) {  //int
       BalanceDTO balance2 = new BalanceDTO();
       //balance2.setBalance(bankService.getAccount(accountNr));
       return balance2.setBalance(bankService.getAccount(accountNr));
      //  return bankService.getAccount(accountNr);        //bankService.getAccount(accountNr)
    } // web:   http://localhost:8080/bankservice/EE4

    @GetMapping("bankservice")
    public List<BankAccountsDTO> getAccountList() {
        return bankService.getAllSqlAccounts();
    } // web:   http://localhost:8080/bankservice

    @PutMapping("bankservice/{accountNo}")
    public void depositSqlMoney(@RequestBody int amount,
                                @PathVariable("accountNo") String accountNr) {
        bankService.depositMoney(amount, accountNr);
    } // web:   http://localhost:8080/bankservice/EE4
    //(:id, :toAccount, :amount, :type, :toAccountId)

    @PutMapping("bankservice/wd/{accountN}")
    public void withdrawSqlMoney(@RequestBody int wdAmount,
                                 @PathVariable("accountN") String accountNr) {
        bankService.withdrawSqlMoney(wdAmount, accountNr);
    } // web:   http://localhost:8080/bankservice/wd/EE4

    @PutMapping("bankservice/transfer")
    public void transfer (@RequestBody TransferMoneyRequest transferAmount) {
    bankService.transferMoney(transferAmount.getFromAccount(), transferAmount.getToAccount(), transferAmount.getTransferAmount());
    } // web:   http://localhost:8080/bankservice/transfer
}
