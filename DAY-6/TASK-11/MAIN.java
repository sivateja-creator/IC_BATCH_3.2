import java.sql.*;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/inactive_student_db";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS inactive_student_db");
            st.executeUpdate("USE inactive_student_db");

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS students (" +
                "student_id INT PRIMARY KEY, " +
                "student_name VARCHAR(100), " +
                "department VARCHAR(50), " +
                "year INT)"
            );

            String insert = "INSERT IGNORE INTO students VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            String[][] students = {
                {"101", "Arun", "CSE", "2"},
                {"102", "Priya", "AIDS", "3"},
                {"103", "Rahul", "ECE", "2"},
                {"104", "Sneha", "IT", "3"},
                {"105", "Kiran", "CSE", "1"},
                {"106", "Divya", "AIDS", "2"},
                {"107", "Manoj", "ECE", "4"},
                {"108", "Anitha", "IT", "1"},
                {"109", "Ravi", "CSE", "3"},
                {"110", "Pooja", "AIDS", "4"}
            };

            for (String[] s : students) {
                ps.setInt(1, Integer.parseInt(s[0]));
                ps.setString(2, s[1]);
                ps.setString(3, s[2]);
                ps.setInt(4, Integer.parseInt(s[3]));
                ps.executeUpdate();
            }

            System.out.println("All Student Records:");
            displayStudents(st);

            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter Student ID to delete: ");
            int id = sc.nextInt();

            String delete = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement deletePs = con.prepareStatement(delete);
            deletePs.setInt(1, id);

            int rows = deletePs.executeUpdate();

            if (rows > 0) {
                System.out.println("Student record deleted successfully!");
            } else {
                System.out.println("No student record found. No record deleted.");
            }

            System.out.println("\nRemaining Student Records:");
            displayStudents(st);

            sc.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void displayStudents(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM students");

        while (rs.next()) {
            System.out.println(
                rs.getInt("student_id") + " | " +
                rs.getString("student_name") + " | " +
                rs.getString("department") + " | " +
                rs.getInt("year")
            );
        }
    }
}