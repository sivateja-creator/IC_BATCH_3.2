import java.util.HashMap;
import java.util.Map;

public class EmployeeSalaryManagement {
    public static void main(String[] args) {

        HashMap<Integer, Integer> employees = new HashMap<>();

        employees.put(101, 25000);
        employees.put(102, 30000);
        employees.put(103, 28000);
        employees.put(104, 35000);
        employees.put(105, 40000);
        employees.put(106, 22000);
        employees.put(107, 32000);
        employees.put(108, 45000);
        employees.put(109, 27000);
        employees.put(110, 38000);

        employees.replace(103, 33000);

        System.out.println("Salary of Employee 105: " + employees.get(105));

        System.out.println("All Employee Salaries:");

        for (Map.Entry<Integer, Integer> entry : employees.entrySet()) {
            System.out.println("Employee ID: " + entry.getKey()
                    + " Salary: " + entry.getValue());
        }

        int highestSalary = 0;
        int highestSalaryEmployee = 0;

        for (Map.Entry<Integer, Integer> entry : employees.entrySet()) {
            if (entry.getValue() > highestSalary) {
                highestSalary = entry.getValue();
                highestSalaryEmployee = entry.getKey();
            }
        }

        System.out.println("Highest Salary Employee ID: " + highestSalaryEmployee);
        System.out.println("Highest Salary: " + highestSalary);

        int totalSalary = 0;

        for (int salary : employees.values()) {
            totalSalary += salary;
        }

        System.out.println("Total Salary Expenditure: " + totalSalary);
    }
}