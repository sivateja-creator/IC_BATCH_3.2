import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    public boolean addEmployee(Employee e) throws SQLException {
        String sql = "INSERT INTO employees VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getEmployeeId());
            ps.setString(2, e.getEmployeeName());
            ps.setString(3, e.getDepartment());
            ps.setDouble(4, e.getSalary());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM employees");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt("employee_id"),
                    rs.getString("employee_name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                ));
            }
        }

        return list;
    }

    public Employee searchEmployee(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE employee_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                    );
                }
            }
        }

        return null;
    }

    public boolean updateEmployee(int id, String name, String dept) throws SQLException {
        String sql = "UPDATE employees SET employee_name = ?, department = ? WHERE employee_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setInt(3, id);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateSalary(int id, double salary) throws SQLException {
        String sql = "UPDATE employees SET salary = ? WHERE employee_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        }
    }

    public List<Employee> getByDepartment(String dept) throws SQLException {
        List<Employee> list = new ArrayList<>();

        String sql = "SELECT * FROM employees WHERE department = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dept);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                    ));
                }
            }
        }

        return list;
    }

    public Employee getHighestPaid() throws SQLException {
        String sql = "SELECT * FROM employees ORDER BY salary DESC LIMIT 1";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return new Employee(
                    rs.getInt("employee_id"),
                    rs.getString("employee_name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                );
            }
        }

        return null;
    }

    public double getAverageSalary() throws SQLException {
        String sql = "SELECT AVG(salary) AS average_salary FROM employees";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble("average_salary");
            }
        }

        return 0;
    }
}