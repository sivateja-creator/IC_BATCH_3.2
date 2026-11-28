import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/order_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?)"
            );

            System.out.print("Enter Order ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            String customer = sc.nextLine();

            System.out.print("Enter Product Name: ");
            String product = sc.nextLine();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            System.out.print("Enter Total Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Order Status: ");
            String status = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, customer);
            ps.setString(3, product);
            ps.setInt(4, quantity);
            ps.setDouble(5, amount);
            ps.setString(6, status);

            ps.executeUpdate();
            System.out.println("Order inserted successfully!");

            Statement st = con.createStatement();

            System.out.println("\nAll Orders:");
            ResultSet rs = st.executeQuery("SELECT * FROM orders");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("order_id") + " " +
                    rs.getString("customer_name") + " " +
                    rs.getString("product_name") + " " +
                    rs.getInt("quantity") + " " +
                    rs.getDouble("total_amount") + " " +
                    rs.getString("order_status")
                );
            }

            System.out.print("\nEnter Order ID to search: ");
            int searchId = sc.nextInt();

            PreparedStatement ps2 = con.prepareStatement(
                "SELECT * FROM orders WHERE order_id = ?"
            );

            ps2.setInt(1, searchId);
            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                System.out.println("Customer: " + rs2.getString("customer_name"));
                System.out.println("Product: " + rs2.getString("product_name"));
                System.out.println("Status: " + rs2.getString("order_status"));
            } else {
                System.out.println("Order not found!");
            }

            sc.nextLine();

            System.out.print("\nEnter Customer Name: ");
            String searchCustomer = sc.nextLine();

            PreparedStatement ps3 = con.prepareStatement(
                "SELECT * FROM orders WHERE customer_name = ?"
            );

            ps3.setString(1, searchCustomer);
            ResultSet rs3 = ps3.executeQuery();

            boolean found = false;

            while (rs3.next()) {
                found = true;
                System.out.println(
                    rs3.getInt("order_id") + " " +
                    rs3.getString("product_name") + " " +
                    rs3.getString("order_status")
                );
            }

            if (!found) {
                System.out.println("No orders found!");
            }

            System.out.print("\nEnter Order ID to update status: ");
            int updateId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Order Status: ");
            String newStatus = sc.nextLine();

            PreparedStatement ps4 = con.prepareStatement(
                "UPDATE orders SET order_status = ? WHERE order_id = ?"
            );

            ps4.setString(1, newStatus);
            ps4.setInt(2, updateId);

            int rows = ps4.executeUpdate();

            if (rows > 0) {
                System.out.println("Order status updated successfully!");
            } else {
                System.out.println("Order not found!");
            }

            System.out.println("\nPending Orders:");

            ResultSet rs4 = st.executeQuery(
                "SELECT * FROM orders WHERE order_status = 'Pending'"
            );

            found = false;

            while (rs4.next()) {
                found = true;
                System.out.println(
                    rs4.getInt("order_id") + " " +
                    rs4.getString("customer_name") + " " +
                    rs4.getString("product_name")
                );
            }

            if (!found) {
                System.out.println("No pending orders!");
            }

            System.out.print("\nEnter Cancelled Order ID to delete: ");
            int deleteId = sc.nextInt();

            PreparedStatement ps5 = con.prepareStatement(
                "DELETE FROM orders WHERE order_id = ? AND order_status = 'Cancelled'"
            );

            ps5.setInt(1, deleteId);

            int deleted = ps5.executeUpdate();

            if (deleted > 0) {
                System.out.println("Cancelled order deleted successfully!");
            } else {
                System.out.println("Cancelled order not found!");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}