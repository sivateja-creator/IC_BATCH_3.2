import java.sql.*;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/electricity_management";
        String username = "root";
        String password = "mysql@123"; // Replace with your MySQL password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS electricity_management");
            st.executeUpdate("USE electricity_management");

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS electricity_bills (" +
                "bill_id INT PRIMARY KEY, " +
                "customer_name VARCHAR(100), " +
                "units_consumed INT, " +
                "amount DOUBLE, " +
                "payment_status VARCHAR(20))"
            );

            Scanner sc = new Scanner(System.in);

            String insert = "INSERT INTO electricity_bills VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            System.out.print("Enter Bill ID: ");
            ps.setInt(1, sc.nextInt());
            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            ps.setString(2, sc.nextLine());

            System.out.print("Enter Units Consumed: ");
            ps.setInt(3, sc.nextInt());

            System.out.print("Enter Bill Amount: ");
            ps.setDouble(4, sc.nextDouble());
            sc.nextLine();

            System.out.print("Enter Payment Status (Paid/Unpaid): ");
            ps.setString(5, sc.nextLine());

            ps.executeUpdate();
            System.out.println("Electricity Bill Inserted Successfully!");

            System.out.println("\nAll Electricity Bills:");
            display(st, "SELECT * FROM electricity_bills");

            System.out.print("\nEnter Bill ID to Search: ");
            int id = sc.nextInt();

            PreparedStatement search = con.prepareStatement(
                "SELECT * FROM electricity_bills WHERE bill_id = ?"
            );
            search.setInt(1, id);
            ResultSet rs = search.executeQuery();

            if (rs.next()) {
                System.out.println("Bill ID: " + rs.getInt("bill_id"));
                System.out.println("Customer: " + rs.getString("customer_name"));
                System.out.println("Units: " + rs.getInt("units_consumed"));
                System.out.println("Amount: " + rs.getDouble("amount"));
                System.out.println("Status: " + rs.getString("payment_status"));
            } else {
                System.out.println("Bill Not Found!");
            }

            System.out.println("\nUnpaid Bills:");
            display(st, "SELECT * FROM electricity_bills WHERE payment_status = 'Unpaid'");

            System.out.println("\nCustomers Consuming More Than 200 Units:");
            display(st, "SELECT * FROM electricity_bills WHERE units_consumed > 200");

            System.out.print("\nEnter Bill ID to Update Payment: ");
            int updateId = sc.nextInt();

            PreparedStatement update = con.prepareStatement(
                "UPDATE electricity_bills SET payment_status = 'Paid' WHERE bill_id = ?"
            );
            update.setInt(1, updateId);

            int rows = update.executeUpdate();

            if (rows > 0) {
                System.out.println("Payment Status Updated Successfully!");
            } else {
                System.out.println("Bill Not Found!");
            }

            ResultSet total = st.executeQuery(
                "SELECT SUM(amount) AS total_unpaid FROM electricity_bills WHERE payment_status = 'Unpaid'"
            );

            if (total.next()) {
                System.out.println("\nTotal Unpaid Bill Amount: " + total.getDouble("total_unpaid"));
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void display(Statement st, String query) throws SQLException {
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println(
                rs.getInt("bill_id") + " | " +
                rs.getString("customer_name") + " | " +
                rs.getInt("units_consumed") + " | " +
                rs.getDouble("amount") + " | " +
                rs.getString("payment_status")
            );
        }
    }
}