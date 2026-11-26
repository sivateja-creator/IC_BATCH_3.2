import java.util.HashMap;

public class BankingAccountManagement {
    public static void main(String[] args) {

        HashMap<Integer, Double> accounts = new HashMap<>();

        accounts.put(1001, 5000.0);
        accounts.put(1002, 10000.0);
        accounts.put(1003, 7500.0);
        accounts.put(1004, 12000.0);
        accounts.put(1005, 8000.0);

        System.out.println("Initial Accounts: " + accounts);

        int accountNumber = 1001;

        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.getOrDefault(accountNumber, 0.0);
            accounts.put(accountNumber, balance + 2000);
            System.out.println("2000 Deposited Successfully");
        }

        accountNumber = 1002;

        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);

            if (balance >= 3000) {
                accounts.put(accountNumber, balance - 3000);
                System.out.println("3000 Withdrawn Successfully");
            } else {
                System.out.println("Insufficient Balance");
            }
        }

        accountNumber = 1003;

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account 1003 Balance: " + accounts.get(accountNumber));
        } else {
            System.out.println("Account Not Found");
        }

        accountNumber = 1006;

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account Found");
        } else {
            System.out.println("Account 1006 Does Not Exist");
        }

        System.out.println("\nAll Bank Accounts:");

        double totalBalance = 0;

        for (var entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() +
                    " Balance: " + entry.getValue());
        }

        for (double balance : accounts.values()) {
            totalBalance += balance;
        }

        System.out.println("Total Bank Balance: " + totalBalance);
    }
}