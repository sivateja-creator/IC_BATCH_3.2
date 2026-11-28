import java.sql.*;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee_report";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS employee_report");
            st.executeUpdate("USE employee_report");

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS employees (" +
                "employee_id INT PRIMARY KEY, " +
                "employee_name VARCHAR(100), " +
                "department VARCHAR(50), " +
                "salary DOUBLE)"
            );

            String insert = "INSERT IGNORE INTO employees VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            Object[][] employees = {
                {101, "Arun", "IT", 35000.0},
                {102, "Priya", "HR", 30000.0},
                {103, "Rahul", "Finance", 40000.0},
                {104, "Sneha", "IT", 45000.0},
                {105, "Kiran", "Sales", 32000.0},
                {106, "Divya", "HR", 38000.0},
                {107, "Manoj", "Finance", 50000.0},
                {108, "Anitha", "IT", 42000.0},
                {109, "Ravi", "Sales", 36000.0},
                {110, "Pooja", "Finance", 48000.0}
            };

            for (Object[] e : employees) {
                ps.setInt(1, (int) e[0]);
                ps.setString(2, (String) e[1]);
                ps.setString(3, (String) e[2]);
                ps.setDouble(4, (double) e[3]);
                ps.executeUpdate();
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Department Name: ");
            String dept = sc.nextLine();

            PreparedStatement search = con.prepareStatement(
                "SELECT * FROM employees WHERE department = ?"
            );
            search.setString(1, dept);

            ResultSet rs = search.executeQuery();

            System.out.println("\nEmployees in " + dept + " Department:");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                    rs.getInt("employee_id") + " | " +
                    rs.getString("employee_name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary")
                );
            }

            if (!found) {
                System.out.println("No employees found!");
            }

            System.out.println("\nDepartment-wise Employee Count:");

            rs = st.executeQuery(
                "SELECT department, COUNT(*) AS total_employees " +
                "FROM employees GROUP BY department"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getString("department") + " : " +
                    rs.getInt("total_employees")
                );
            }

            rs = st.executeQuery(
                "SELECT AVG(salary) AS average_salary FROM employees"
            );

            if (rs.next()) {
                System.out.println(
                    "\nAverage Salary: " + rs.getDouble("average_salary")
                );
            }

            sc.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}