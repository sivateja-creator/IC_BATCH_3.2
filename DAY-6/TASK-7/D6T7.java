import java.sql.*;
import java.util.Scanner;

public class D6T7 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/bank_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Account ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Account Type: ");
            String type = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO bank_accounts VALUES (?, ?, ?, ?)"
            );

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, type);
            ps.setDouble(4, balance);

            ps.executeUpdate();
            System.out.println("Account created successfully!");

            System.out.println("\nAll Bank Accounts:");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bank_accounts");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("account_id") + " " +
                    rs.getString("customer_name") + " " +
                    rs.getString("account_type") + " " +
                    rs.getDouble("balance")
                );
            }

            System.out.print("\nEnter Account ID to search: ");
            int searchId = sc.nextInt();

            PreparedStatement ps2 = con.prepareStatement(
                "SELECT * FROM bank_accounts WHERE account_id = ?"
            );

            ps2.setInt(1, searchId);
            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                System.out.println("Customer: " + rs2.getString("customer_name"));
                System.out.println("Balance: " + rs2.getDouble("balance"));
            } else {
                System.out.println("Account not found!");
            }

            System.out.print("\nEnter Account ID for transaction: ");
            int transactionId = sc.nextInt();

            PreparedStatement ps3 = con.prepareStatement(
                "SELECT balance FROM bank_accounts WHERE account_id = ?"
            );

            ps3.setInt(1, transactionId);
            ResultSet rs3 = ps3.executeQuery();

            if (rs3.next()) {
                double currentBalance = rs3.getDouble("balance");

                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                if (amount <= 0) {
                    System.out.println("Enter a valid amount!");
                } else if (choice == 1) {
                    currentBalance += amount;
                    updateBalance(con, transactionId, currentBalance);
                    System.out.println("Amount deposited successfully!");
                } else if (choice == 2) {
                    if (amount > currentBalance) {
                        System.out.println("Insufficient balance! Withdrawal denied.");
                    } else {
                        currentBalance -= amount;
                        updateBalance(con, transactionId, currentBalance);
                        System.out.println("Amount withdrawn successfully!");
                    }
                } else {
                    System.out.println("Invalid choice!");
                }

                PreparedStatement ps4 = con.prepareStatement(
                    "SELECT balance FROM bank_accounts WHERE account_id = ?"
                );

                ps4.setInt(1, transactionId);
                ResultSet rs4 = ps4.executeQuery();

                if (rs4.next()) {
                    System.out.println("Updated Balance: " + rs4.getDouble("balance"));
                }

            } else {
                System.out.println("Account not found!");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void updateBalance(Connection con, int id, double balance) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE bank_accounts SET balance = ? WHERE account_id = ?"
        );

        ps.setDouble(1, balance);
        ps.setInt(2, id);
        ps.executeUpdate();
    }
}