import java.sql.*;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/login_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS login_management");
            st.executeUpdate("USE login_management");

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS users (" +
                "user_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "username VARCHAR(50) UNIQUE, " +
                "password VARCHAR(255), " +
                "email VARCHAR(100))"
            );

            Scanner sc = new Scanner(System.in);

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Username: ");
                String user = sc.nextLine();

                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, user);
                ps.setString(2, pass);
                ps.setString(3, email);

                ps.executeUpdate();

                System.out.println("Registration Successful!");

            } else if (choice == 2) {
                System.out.print("Enter Username: ");
                String user = sc.nextLine();

                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, user);
                ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    System.out.println("Login Successful! Welcome " + user);
                } else {
                    System.out.println("Invalid Username or Password!");
                }

            } else {
                System.out.println("Invalid Choice!");
            }

            sc.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}