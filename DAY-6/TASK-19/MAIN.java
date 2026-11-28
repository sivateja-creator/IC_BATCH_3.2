import java.sql.*;

public class MAIN {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/purchase_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS purchase_management");
            st.executeUpdate("USE purchase_management");

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS customers (" +
                "customer_id INT PRIMARY KEY, " +
                "customer_name VARCHAR(100), " +
                "email VARCHAR(100))"
            );

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS products (" +
                "product_id INT PRIMARY KEY, " +
                "product_name VARCHAR(100), " +
                "price DOUBLE)"
            );

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS orders (" +
                "order_id INT PRIMARY KEY, " +
                "customer_id INT, " +
                "product_id INT, " +
                "quantity INT, " +
                "total_amount DOUBLE, " +
                "FOREIGN KEY (customer_id) REFERENCES customers(customer_id), " +
                "FOREIGN KEY (product_id) REFERENCES products(product_id))"
            );

            String customerQuery = "INSERT IGNORE INTO customers VALUES (?, ?, ?)";
            PreparedStatement cp = con.prepareStatement(customerQuery);

            String[][] customers = {
                {"101", "Arun", "arun@gmail.com"},
                {"102", "Priya", "priya@gmail.com"},
                {"103", "Rahul", "rahul@gmail.com"},
                {"104", "Sneha", "sneha@gmail.com"},
                {"105", "Kiran", "kiran@gmail.com"}
            };

            for (String[] c : customers) {
                cp.setInt(1, Integer.parseInt(c[0]));
                cp.setString(2, c[1]);
                cp.setString(3, c[2]);
                cp.executeUpdate();
            }

            String productQuery = "INSERT IGNORE INTO products VALUES (?, ?, ?)";
            PreparedStatement pp = con.prepareStatement(productQuery);

            Object[][] products = {
                {201, "Laptop", 55000.0},
                {202, "Mobile", 15000.0},
                {203, "Keyboard", 800.0},
                {204, "Mouse", 500.0},
                {205, "Monitor", 12000.0}
            };

            for (Object[] p : products) {
                pp.setInt(1, (int) p[0]);
                pp.setString(2, (String) p[1]);
                pp.setDouble(3, (double) p[2]);
                pp.executeUpdate();
            }

            String orderQuery = "INSERT IGNORE INTO orders VALUES (?, ?, ?, ?, ?)";
            PreparedStatement op = con.prepareStatement(orderQuery);

            Object[][] orders = {
                {301, 101, 201, 1, 55000.0},
                {302, 102, 202, 2, 30000.0},
                {303, 103, 203, 3, 2400.0},
                {304, 101, 204, 2, 1000.0},
                {305, 104, 205, 1, 12000.0},
                {306, 102, 201, 1, 55000.0}
            };

            for (Object[] o : orders) {
                op.setInt(1, (int) o[0]);
                op.setInt(2, (int) o[1]);
                op.setInt(3, (int) o[2]);
                op.setInt(4, (int) o[3]);
                op.setDouble(5, (double) o[4]);
                op.executeUpdate();
            }

            System.out.println("Customer Names and Purchased Products:");

            ResultSet rs = st.executeQuery(
                "SELECT c.customer_name, p.product_name " +
                "FROM customers c " +
                "JOIN orders o ON c.customer_id = o.customer_id " +
                "JOIN products p ON o.product_id = p.product_id"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getString("customer_name") + " - " +
                    rs.getString("product_name")
                );
            }

            System.out.println("\nProduct Names, Quantities and Total Amounts:");

            rs = st.executeQuery(
                "SELECT p.product_name, o.quantity, o.total_amount " +
                "FROM orders o " +
                "JOIN products p ON o.product_id = p.product_id"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getString("product_name") + " | " +
                    rs.getInt("quantity") + " | " +
                    rs.getDouble("total_amount")
                );
            }

            System.out.println("\nAll Customers Including Customers Without Orders:");

            rs = st.executeQuery(
                "SELECT c.customer_name, o.order_id " +
                "FROM customers c " +
                "LEFT JOIN orders o ON c.customer_id = o.customer_id"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getString("customer_name") + " | " +
                    rs.getObject("order_id")
                );
            }

            System.out.println("\nTotal Orders for Each Customer:");

            rs = st.executeQuery(
                "SELECT c.customer_name, COUNT(o.order_id) AS total_orders " +
                "FROM customers c " +
                "LEFT JOIN orders o ON c.customer_id = o.customer_id " +
                "GROUP BY c.customer_id, c.customer_name"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getString("customer_name") + " : " +
                    rs.getInt("total_orders")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}