import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private EmployeeDAO dao = new EmployeeDAO();

    public boolean addEmployee(Employee e) throws SQLException {
        return dao.addEmployee(e);
    }

    public List<Employee> viewEmployees() throws SQLException {
        return dao.getAllEmployees();
    }

    public Employee searchEmployee(int id) throws SQLException {
        return dao.searchEmployee(id);
    }

    public boolean updateEmployee(int id, String name, String dept) throws SQLException {
        return dao.updateEmployee(id, name, dept);
    }

    public boolean updateSalary(int id, double salary) throws SQLException {
        return dao.updateSalary(id, salary);
    }

    public boolean deleteEmployee(int id) throws SQLException {
        return dao.deleteEmployee(id);
    }

    public List<Employee> getByDepartment(String dept) throws SQLException {
        return dao.getByDepartment(dept);
    }

    public Employee getHighestPaid() throws SQLException {
        return dao.getHighestPaid();
    }

    public double getAverageSalary() throws SQLException {
        return dao.getAverageSalary();
    }
}