import java.sql.*;
import java.util.Scanner;

public class D6T6 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employee_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);

            System.out.println("All Employee Details:");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("employee_id") + " " +
                    rs.getString("employee_name") + " " +
                    rs.getString("department") + " " +
                    rs.getDouble("salary")
                );
            }

            System.out.print("\nEnter Employee ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            String update = "UPDATE employees SET salary = ? WHERE employee_id = ?";
            PreparedStatement ps = con.prepareStatement(update);

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nSalary updated successfully!");

                PreparedStatement ps2 = con.prepareStatement(
                    "SELECT * FROM employees WHERE employee_id = ?"
                );

                ps2.setInt(1, id);
                ResultSet rs2 = ps2.executeQuery();

                if (rs2.next()) {
                    System.out.println("Updated Employee Information:");
                    System.out.println("Employee ID: " + rs2.getInt("employee_id"));
                    System.out.println("Name: " + rs2.getString("employee_name"));
                    System.out.println("Department: " + rs2.getString("department"));
                    System.out.println("Salary: " + rs2.getDouble("salary"));
                }

            } else {
                System.out.println("Employee ID does not exist!");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}