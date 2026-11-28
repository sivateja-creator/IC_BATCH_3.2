import java.sql.*;
import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/employee_db",
            "root",
            "mysql@123"
        );

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        String sql = "INSERT INTO employees VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, designation);
        ps.setDouble(4, salary);
        ps.setString(5, dept);

        ps.executeUpdate();
        System.out.println("\nEmployee Inserted Successfully!");

        ResultSet all = con.createStatement().executeQuery(
            "SELECT * FROM employees"
        );

        System.out.println("\nAll Employees:");
        while (all.next()) {
            System.out.println(
                all.getInt("employee_id") + " " +
                all.getString("employee_name") + " " +
                all.getString("designation") + " " +
                all.getDouble("salary") + " " +
                all.getString("department")
            );
        }

        System.out.print("\nEnter Employee ID to Search: ");
        int searchId = sc.nextInt();

        PreparedStatement search = con.prepareStatement(
            "SELECT employee_name, designation, salary FROM employees WHERE employee_id = ?"
        );

        search.setInt(1, searchId);
        ResultSet rs = search.executeQuery();

        if (rs.next()) {
            System.out.println("\nEmployee Found!");
            System.out.println("Name: " + rs.getString("employee_name"));
            System.out.println("Designation: " + rs.getString("designation"));
            System.out.println("Salary: " + rs.getDouble("salary"));
        } else {
            System.out.println("Employee ID does not exist!");
        }

        con.close();
        sc.close();
    }
}