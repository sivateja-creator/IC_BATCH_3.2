import java.sql.*;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sales_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS sales_management");
            st.executeUpdate("USE sales_management");

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS sales (" +
                "sale_id INT PRIMARY KEY, " +
                "product_name VARCHAR(100), " +
                "quantity INT, " +
                "amount DOUBLE, " +
                "sale_date DATE)"
            );

            String insert = "INSERT IGNORE INTO sales VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            Object[][] sales = {
                {101, "Laptop", 2, 110000.0, "2026-11-20"},
                {102, "Mobile", 3, 45000.0, "2026-11-20"},
                {103, "Keyboard", 5, 4000.0, "2026-11-21"},
                {104, "Mouse", 4, 2000.0, "2026-11-21"},
                {105, "Monitor", 2, 24000.0, "2026-11-22"},
                {106, "Headphones", 3, 7500.0, "2026-11-22"},
                {107, "Tablet", 1, 20000.0, "2026-11-23"},
                {108, "Smart Watch", 2, 7000.0, "2026-11-23"},
                {109, "Printer", 1, 9000.0, "2026-11-24"},
                {110, "Speaker", 4, 7200.0, "2026-11-24"},
                {111, "Laptop", 1, 55000.0, "2026-11-25"},
                {112, "Mobile", 2, 30000.0, "2026-11-25"},
                {113, "Keyboard", 3, 2400.0, "2026-11-26"},
                {114, "Monitor", 1, 12000.0, "2026-11-27"},
                {115, "Headphones", 2, 5000.0, "2026-11-28"}
            };

            for (Object[] s : sales) {
                ps.setInt(1, (int) s[0]);
                ps.setString(2, (String) s[1]);
                ps.setInt(3, (int) s[2]);
                ps.setDouble(4, (double) s[3]);
                ps.setDate(5, Date.valueOf((String) s[4]));
                ps.executeUpdate();
            }

            System.out.println("All Sales Records:");
            ResultSet rs = st.executeQuery("SELECT * FROM sales");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("sale_id") + " | " +
                    rs.getString("product_name") + " | " +
                    rs.getInt("quantity") + " | " +
                    rs.getDouble("amount") + " | " +
                    rs.getDate("sale_date")
                );
            }

            rs = st.executeQuery(
                "SELECT SUM(amount) AS total, AVG(amount) AS average, " +
                "MAX(amount) AS highest, MIN(amount) AS lowest, " +
                "COUNT(*) AS transactions FROM sales"
            );

            if (rs.next()) {
                System.out.println("\nTotal Revenue: " + rs.getDouble("total"));
                System.out.println("Average Sales: " + rs.getDouble("average"));
                System.out.println("Highest Sale: " + rs.getDouble("highest"));
                System.out.println("Lowest Sale: " + rs.getDouble("lowest"));
                System.out.println("Total Transactions: " + rs.getInt("transactions"));
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("\nEnter Date (YYYY-MM-DD): ");
            String date = sc.nextLine();

            PreparedStatement search = con.prepareStatement(
                "SELECT * FROM sales WHERE sale_date = ?"
            );

            search.setDate(1, Date.valueOf(date));
            rs = search.executeQuery();

            System.out.println("\nSales Records for " + date + ":");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                    rs.getInt("sale_id") + " | " +
                    rs.getString("product_name") + " | " +
                    rs.getInt("quantity") + " | " +
                    rs.getDouble("amount") + " | " +
                    rs.getDate("sale_date")
                );
            }

            if (!found) {
                System.out.println("No sales found for this date.");
            }

            sc.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}