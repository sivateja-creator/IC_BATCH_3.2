import java.util.*;
import java.sql.SQLException;

public class MAIN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (true) {
            try {
                System.out.println("\n========== EMPLOYEE MANAGEMENT SYSTEM ==========");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Search Employee");
                System.out.println("4. Update Employee Details");
                System.out.println("5. Update Employee Salary");
                System.out.println("6. Delete Employee");
                System.out.println("7. Display Employees by Department");
                System.out.println("8. Display Highest Paid Employee");
                System.out.println("9. Display Average Salary");
                System.out.println("10. Exit");

                System.out.print("\nEnter Your Choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = Double.parseDouble(sc.nextLine());

                        if (salary < 0 || name.trim().isEmpty() || dept.trim().isEmpty()) {
                            System.out.println("Invalid Employee Details!");
                            break;
                        }

                        Employee e = new Employee(id, name, dept, salary);

                        if (service.addEmployee(e))
                            System.out.println("Employee Added Successfully!");
                        break;

                    case 2:
                        List<Employee> employees = service.viewEmployees();

                        if (employees.isEmpty()) {
                            System.out.println("No Employees Found!");
                        } else {
                            for (Employee emp : employees)
                                System.out.println(emp);
                        }
                        break;

                    case 3:
                        System.out.print("Enter Employee ID: ");
                        id = Integer.parseInt(sc.nextLine());

                        Employee emp = service.searchEmployee(id);

                        if (emp != null)
                            System.out.println(emp);
                        else
                            System.out.println("Employee Not Found!");
                        break;

                    case 4:
                        System.out.print("Enter Employee ID: ");
                        id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter New Name: ");
                        name = sc.nextLine();

                        System.out.print("Enter New Department: ");
                        dept = sc.nextLine();

                        if (name.trim().isEmpty() || dept.trim().isEmpty()) {
                            System.out.println("Invalid Details!");
                            break;
                        }

                        if (service.updateEmployee(id, name, dept))
                            System.out.println("Employee Details Updated!");
                        else
                            System.out.println("Employee Not Found!");
                        break;

                    case 5:
                        System.out.print("Enter Employee ID: ");
                        id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter New Salary: ");
                        salary = Double.parseDouble(sc.nextLine());

                        if (salary < 0) {
                            System.out.println("Invalid Salary!");
                            break;
                        }

                        if (service.updateSalary(id, salary))
                            System.out.println("Salary Updated Successfully!");
                        else
                            System.out.println("Employee Not Found!");
                        break;

                    case 6:
                        System.out.print("Enter Employee ID: ");
                        id = Integer.parseInt(sc.nextLine());

                        if (service.deleteEmployee(id))
                            System.out.println("Employee Deleted Successfully!");
                        else
                            System.out.println("Employee Not Found!");
                        break;

                    case 7:
                        System.out.print("Enter Department: ");
                        dept = sc.nextLine();

                        employees = service.getByDepartment(dept);

                        if (employees.isEmpty()) {
                            System.out.println("No Employees Found!");
                        } else {
                            for (Employee emp1 : employees)
                                System.out.println(emp1);
                        }
                        break;

                    case 8:
                        emp = service.getHighestPaid();

                        if (emp != null)
                            System.out.println("Highest Paid Employee:\n" + emp);
                        else
                            System.out.println("No Employees Found!");
                        break;

                    case 9:
                        double average = service.getAverageSalary();
                        System.out.println("Average Salary: " + average);
                        break;

                    case 10:
                        System.out.println("Thank You! Exiting Application.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid Choice! Enter 1 to 10.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid Input! Please enter a valid number.");
            } catch (SQLException e) {
                System.out.println("Database Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}