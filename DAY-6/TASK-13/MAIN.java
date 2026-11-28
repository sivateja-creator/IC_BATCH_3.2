import java.sql.*;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/product_management";
        String username = "root";
        String password = "mysql@123"; 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS product_management");
            st.executeUpdate("USE product_management");

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS products (" +
                "product_id INT PRIMARY KEY, " +
                "product_name VARCHAR(100), " +
                "price DOUBLE)"
            );

            String insert = "INSERT IGNORE INTO products VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            Object[][] products = {
                {101, "Laptop", 55000.0},
                {102, "Mobile", 15000.0},
                {103, "Keyboard", 800.0},
                {104, "Mouse", 500.0},
                {105, "Monitor", 12000.0},
                {106, "Headphones", 2500.0},
                {107, "Tablet", 20000.0},
                {108, "Smart Watch", 3500.0},
                {109, "Printer", 9000.0},
                {110, "Speaker", 1800.0}
            };

            for (Object[] p : products) {
                ps.setInt(1, (int) p[0]);
                ps.setString(2, (String) p[1]);
                ps.setDouble(3, (double) p[2]);
                ps.executeUpdate();
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Minimum Price: ");
            double min = sc.nextDouble();

            System.out.print("Enter Maximum Price: ");
            double max = sc.nextDouble();

            String query = "SELECT product_name, price FROM products WHERE price BETWEEN ? AND ?";
            PreparedStatement search = con.prepareStatement(query);

            search.setDouble(1, min);
            search.setDouble(2, max);

            ResultSet rs = search.executeQuery();

            boolean found = false;

            System.out.println("\nProducts Within Price Range:");

            while (rs.next()) {
                found = true;
                System.out.println(
                    rs.getString("product_name") + " - Rs. " +
                    rs.getDouble("price")
                );
            }

            if (!found) {
                System.out.println("No products available in this price range.");
            }

            sc.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}