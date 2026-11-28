import java.sql.*;
import java.util.Scanner;

public class D6T3 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/inventory_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);

            String insert = "INSERT INTO products VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Stock Quantity: ");
            int stock = sc.nextInt();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, category);
            ps.setDouble(4, price);
            ps.setInt(5, stock);

            ps.executeUpdate();
            System.out.println("Product inserted successfully!");

            Statement st = con.createStatement();

            System.out.println("\nAll Products:");
            ResultSet rs = st.executeQuery("SELECT * FROM products");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("product_id") + " " +
                    rs.getString("product_name") + " " +
                    rs.getString("category") + " " +
                    rs.getDouble("price") + " " +
                    rs.getInt("stock_quantity")
                );
            }

            System.out.print("\nEnter Product ID to search: ");
            int searchId = sc.nextInt();

            PreparedStatement ps2 = con.prepareStatement(
                "SELECT * FROM products WHERE product_id = ?"
            );

            ps2.setInt(1, searchId);
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                System.out.println("Product: " + rs2.getString("product_name"));
            }

            sc.nextLine();

            System.out.print("\nEnter Category: ");
            String cat = sc.nextLine();

            PreparedStatement ps3 = con.prepareStatement(
                "SELECT * FROM products WHERE category = ?"
            );

            ps3.setString(1, cat);
            ResultSet rs3 = ps3.executeQuery();

            System.out.println("\nProducts by Category:");

            while (rs3.next()) {
                System.out.println(rs3.getString("product_name"));
            }

            System.out.println("\nProducts with Stock Below 10:");

            ResultSet rs4 = st.executeQuery(
                "SELECT * FROM products WHERE stock_quantity < 10"
            );

            while (rs4.next()) {
                System.out.println(rs4.getString("product_name"));
            }

            ResultSet rs5 = st.executeQuery(
                "SELECT COUNT(*) AS total FROM products"
            );

            if (rs5.next()) {
                System.out.println("Total Products: " + rs5.getInt("total"));
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}