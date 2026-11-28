import java.sql.*;
import java.util.Scanner;

public class StudentRegistration {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db",
            "root",
            "mysql@123"
        );

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        ps.setString(4, dept);
        ps.setString(5, email);

        ps.executeUpdate();

        System.out.println("\nStudent Registered Successfully!");

        ResultSet rs = con.createStatement().executeQuery(
            "SELECT * FROM students"
        );

        System.out.println("\nRegistered Students:");

        while (rs.next()) {
            System.out.println(
                rs.getInt("student_id") + " " +
                rs.getString("student_name") + " " +
                rs.getInt("age") + " " +
                rs.getString("department") + " " +
                rs.getString("email")
            );
        }

        con.close();
        sc.close();
    }
}