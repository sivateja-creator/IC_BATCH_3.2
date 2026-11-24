class BankAccount {
    private String accountHolder;
    private double balance;

    public void setAccountHolder(String name) {
        accountHolder = name;
    }

    public void setBalance(double balance) {
        if (balance >= 0)
            this.balance = balance;
        else
            System.out.println("Invalid balance");
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
        else
            System.out.println("Invalid deposit");
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance)
            balance -= amount;
        else
            System.out.println("Invalid withdrawal");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.setAccountHolder("Rahul");
        account.setBalance(5000);
        account.setBalance(-1000);

        account.deposit(2000);
        account.withdraw(1000);
        account.withdraw(10000);

        System.out.println("Balance: " + account.getBalance());
    }
}