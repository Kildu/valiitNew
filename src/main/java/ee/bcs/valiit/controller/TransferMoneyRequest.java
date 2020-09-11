package ee.bcs.valiit.controller;

public class TransferMoneyRequest {
    String fromAccount;
    String toAccount;
    int transferAmount;

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        this.transferAmount = transferAmount;
    }
}
