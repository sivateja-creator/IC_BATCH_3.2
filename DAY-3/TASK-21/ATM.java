public class ATM {
    double balance = 10000;
    double withdrawalAmount = 0;

    void withdraw() {
        try {
            int times = (int) balance / (int) withdrawalAmount;
            System.out.println("Number of Withdrawals: " + times);
        } catch (ArithmeticException e) {
            System.out.println("Invalid withdrawal amount");
        }
    }

    public static void main(String[] args) {
        ATM a = new ATM();

        a.withdrawalAmount = 1000;
        a.withdraw();

        a.withdrawalAmount = 500;
        a.withdraw();

        a.withdrawalAmount = 0;
        a.withdraw();
    }
}