import java.sql.*;
import java.util.Scanner;

public class D6T4 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/customer_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);

            String insert = "INSERT INTO customers VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter City: ");
            String city = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, city);

            ps.executeUpdate();
            System.out.println("Customer registered successfully!");

            System.out.println("\nAll Customers:");

            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM customers");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                System.out.println(
                    rs1.getInt("customer_id") + " " +
                    rs1.getString("customer_name") + " " +
                    rs1.getString("email") + " " +
                    rs1.getString("phone") + " " +
                    rs1.getString("city")
                );
            }

            System.out.print("\nEnter Customer ID to search: ");
            int searchId = sc.nextInt();

            PreparedStatement ps2 = con.prepareStatement(
                "SELECT * FROM customers WHERE customer_id = ?"
            );

            ps2.setInt(1, searchId);
            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                System.out.println("Customer Found: " + rs2.getString("customer_name"));
            } else {
                System.out.println("No customer found!");
            }

            sc.nextLine();

            System.out.print("\nEnter Phone Number to search: ");
            String searchPhone = sc.nextLine();

            PreparedStatement ps3 = con.prepareStatement(
                "SELECT * FROM customers WHERE phone = ?"
            );

            ps3.setString(1, searchPhone);
            ResultSet rs3 = ps3.executeQuery();

            if (rs3.next()) {
                System.out.println("Customer Found: " + rs3.getString("customer_name"));
            } else {
                System.out.println("No customer found!");
            }

            System.out.print("\nEnter City to search: ");
            String searchCity = sc.nextLine();

            PreparedStatement ps4 = con.prepareStatement(
                "SELECT * FROM customers WHERE city = ?"
            );

            ps4.setString(1, searchCity);
            ResultSet rs4 = ps4.executeQuery();

            boolean found = false;

            while (rs4.next()) {
                found = true;
                System.out.println(
                    rs4.getInt("customer_id") + " " +
                    rs4.getString("customer_name") + " " +
                    rs4.getString("city")
                );
            }

            if (!found) {
                System.out.println("No customers found in this city!");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}