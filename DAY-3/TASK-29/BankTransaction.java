public class BankTransaction {
    int balance = 10000;

    void withdraw(String amount) {
        try {
            int withdrawalAmount = Integer.parseInt(amount);

            if (withdrawalAmount <= 0) {
                throw new IllegalArgumentException("Invalid withdrawal amount");
            }

            if (withdrawalAmount > balance) {
                throw new IllegalArgumentException("Insufficient balance");
            }

            balance = balance - withdrawalAmount;

            System.out.println("Transaction Successful");
            System.out.println("Remaining Balance: " + balance);

        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        BankTransaction b = new BankTransaction();

        b.withdraw("2000");
        b.withdraw("15000");
        b.withdraw("abc");
        b.withdraw("-500");
        b.withdraw("0");
    }
}