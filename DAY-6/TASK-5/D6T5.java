import java.sql.*;
import java.util.Scanner;

public class D6T5 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);

            String insert = "INSERT INTO student_marks VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            System.out.print("Enter Mark ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Subject: ");
            String subject = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            String result = marks >= 35 ? "PASS" : "FAIL";

            ps.setInt(1, id);
            ps.setInt(2, studentId);
            ps.setString(3, subject);
            ps.setInt(4, marks);
            ps.setString(5, result);

            ps.executeUpdate();
            System.out.println("Marks inserted successfully!");

            System.out.println("\nAll Student Marks:");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student_marks");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("mark_id") + " " +
                    rs.getInt("student_id") + " " +
                    rs.getString("subject") + " " +
                    rs.getInt("marks") + " " +
                    rs.getString("result")
                );
            }

            System.out.print("\nEnter Student ID to search: ");
            int searchId = sc.nextInt();

            PreparedStatement ps2 = con.prepareStatement(
                "SELECT * FROM student_marks WHERE student_id = ?"
            );

            ps2.setInt(1, searchId);
            ResultSet rs2 = ps2.executeQuery();

            boolean found = false;

            while (rs2.next()) {
                found = true;
                System.out.println(
                    rs2.getString("subject") + " - " +
                    rs2.getInt("marks") + " - " +
                    rs2.getString("result")
                );
            }

            if (!found) {
                System.out.println("No student marks found!");
            }

            System.out.println("\nStudents Scoring Above 80:");

            ResultSet rs3 = st.executeQuery(
                "SELECT * FROM student_marks WHERE marks > 80"
            );

            while (rs3.next()) {
                System.out.println(
                    rs3.getInt("student_id") + " - " +
                    rs3.getString("subject") + " - " +
                    rs3.getInt("marks")
                );
            }

            System.out.println("\nFailed Students:");

            ResultSet rs4 = st.executeQuery(
                "SELECT * FROM student_marks WHERE marks < 35"
            );

            while (rs4.next()) {
                System.out.println(
                    rs4.getInt("student_id") + " - " +
                    rs4.getString("subject") + " - " +
                    rs4.getInt("marks")
                );
            }

            System.out.print("\nEnter Mark ID to update: ");
            int updateId = sc.nextInt();

            System.out.print("Enter New Marks: ");
            int newMarks = sc.nextInt();

            String newResult = newMarks >= 35 ? "PASS" : "FAIL";

            PreparedStatement ps3 = con.prepareStatement(
                "UPDATE student_marks SET marks = ?, result = ? WHERE mark_id = ?"
            );

            ps3.setInt(1, newMarks);
            ps3.setString(2, newResult);
            ps3.setInt(3, updateId);

            int rows = ps3.executeUpdate();

            if (rows > 0) {
                System.out.println("Marks updated successfully!");
            } else {
                System.out.println("Mark record not found!");
            }

            ResultSet rs5 = st.executeQuery(
                "SELECT MAX(marks) AS highest_marks FROM student_marks"
            );

            if (rs5.next()) {
                System.out.println("\nHighest Marks: " + rs5.getInt("highest_marks"));
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}