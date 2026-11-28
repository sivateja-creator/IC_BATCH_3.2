import java.sql.*;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/customer_update_db";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS customer_update_db");
            st.executeUpdate("USE customer_update_db");

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS customers (" +
                "customer_id INT PRIMARY KEY, " +
                "customer_name VARCHAR(100), " +
                "email VARCHAR(100), " +
                "phone VARCHAR(15))"
            );

            String insert = "INSERT IGNORE INTO customers VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            String[][] customers = {
                {"101", "Arun", "arun@gmail.com", "9876543210"},
                {"102", "Priya", "priya@gmail.com", "9876543211"},
                {"103", "Rahul", "rahul@gmail.com", "9876543212"},
                {"104", "Sneha", "sneha@gmail.com", "9876543213"},
                {"105", "Kiran", "kiran@gmail.com", "9876543214"},
                {"106", "Divya", "divya@gmail.com", "9876543215"},
                {"107", "Manoj", "manoj@gmail.com", "9876543216"},
                {"108", "Anitha", "anitha@gmail.com", "9876543217"},
                {"109", "Ravi", "ravi@gmail.com", "9876543218"},
                {"110", "Pooja", "pooja@gmail.com", "9876543219"}
            };

            for (String[] c : customers) {
                ps.setInt(1, Integer.parseInt(c[0]));
                ps.setString(2, c[1]);
                ps.setString(3, c[2]);
                ps.setString(4, c[3]);
                ps.executeUpdate();
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            PreparedStatement search = con.prepareStatement(
                "SELECT * FROM customers WHERE customer_id = ?"
            );
            search.setInt(1, id);

            ResultSet rs = search.executeQuery();

            if (rs.next()) {
                System.out.println("\nExisting Customer Details:");
                System.out.println("Name: " + rs.getString("customer_name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getString("phone"));

                System.out.print("\nEnter New Email: ");
                String email = sc.nextLine();

                System.out.print("Enter New Phone Number: ");
                String phone = sc.nextLine();

                PreparedStatement update = con.prepareStatement(
                    "UPDATE customers SET email = ?, phone = ? WHERE customer_id = ?"
                );

                update.setString(1, email);
                update.setString(2, phone);
                update.setInt(3, id);

                update.executeUpdate();

                System.out.println("\nCustomer Details Updated Successfully!");

                PreparedStatement updated = con.prepareStatement(
                    "SELECT * FROM customers WHERE customer_id = ?"
                );
                updated.setInt(1, id);

                ResultSet newRs = updated.executeQuery();

                if (newRs.next()) {
                    System.out.println("\nUpdated Customer Details:");
                    System.out.println("Customer ID: " + newRs.getInt("customer_id"));
                    System.out.println("Name: " + newRs.getString("customer_name"));
                    System.out.println("Email: " + newRs.getString("email"));
                    System.out.println("Phone: " + newRs.getString("phone"));
                }

            } else {
                System.out.println("Customer ID Not Found!");
            }

            sc.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}