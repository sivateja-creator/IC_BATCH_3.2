import java.sql.*;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/attendance_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS attendance_management");
            st.executeUpdate("USE attendance_management");

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS attendance (" +
                "attendance_id INT PRIMARY KEY, " +
                "student_id INT, " +
                "student_name VARCHAR(100), " +
                "total_classes INT, " +
                "attended_classes INT, " +
                "attendance_percentage DOUBLE)"
            );

            Scanner sc = new Scanner(System.in);

            String insert = "INSERT INTO attendance VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            System.out.print("Enter Attendance ID: ");
            int aid = sc.nextInt();

            System.out.print("Enter Student ID: ");
            int sid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Total Classes: ");
            int total = sc.nextInt();

            System.out.print("Enter Attended Classes: ");
            int attended = sc.nextInt();

            double percentage = total > 0 ? (attended * 100.0) / total : 0;

            ps.setInt(1, aid);
            ps.setInt(2, sid);
            ps.setString(3, name);
            ps.setInt(4, total);
            ps.setInt(5, attended);
            ps.setDouble(6, percentage);

            ps.executeUpdate();

            System.out.println("Attendance Inserted Successfully!");

            System.out.println("\nAll Attendance Records:");
            display(st, "SELECT * FROM attendance");

            System.out.print("\nEnter Student ID to Search: ");
            int searchId = sc.nextInt();

            PreparedStatement search = con.prepareStatement(
                "SELECT * FROM attendance WHERE student_id = ?"
            );
            search.setInt(1, searchId);

            ResultSet rs = search.executeQuery();

            if (rs.next()) {
                System.out.println("Student Name: " + rs.getString("student_name"));
                System.out.println("Attendance Percentage: " +
                    rs.getDouble("attendance_percentage") + "%");
            } else {
                System.out.println("Student Not Found!");
            }

            System.out.print("\nEnter Student ID to Update Attendance: ");
            int updateId = sc.nextInt();

            PreparedStatement update = con.prepareStatement(
                "UPDATE attendance SET total_classes = total_classes + 1, " +
                "attended_classes = attended_classes + 1, " +
                "attendance_percentage = " +
                "(attended_classes + 1) * 100.0 / (total_classes + 1) " +
                "WHERE student_id = ?"
            );

            update.setInt(1, updateId);

            int rows = update.executeUpdate();

            if (rows > 0) {
                System.out.println("Attendance Updated Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

            System.out.println("\nStudents Below 75% Attendance:");
            display(st, "SELECT * FROM attendance WHERE attendance_percentage < 75");

            System.out.println("\nStudents Above 90% Attendance:");
            display(st, "SELECT * FROM attendance WHERE attendance_percentage > 90");

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void display(Statement st, String query) throws SQLException {
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println(
                rs.getInt("attendance_id") + " | " +
                rs.getInt("student_id") + " | " +
                rs.getString("student_name") + " | " +
                rs.getInt("total_classes") + " | " +
                rs.getInt("attended_classes") + " | " +
                rs.getDouble("attendance_percentage") + "%"
            );
        }
    }
}