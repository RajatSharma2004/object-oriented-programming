public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + accountHolder);
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("A123", "Rajat", 5000);
        sa.displayAccountInfo();
        System.out.println("Balance: " + sa.getBalance());
    }
}
