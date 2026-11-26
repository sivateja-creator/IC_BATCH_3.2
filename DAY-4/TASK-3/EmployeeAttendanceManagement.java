import java.util.ArrayList;

public class EmployeeAttendanceManagement {
    public static void main(String[] args) {

        ArrayList<String> employees = new ArrayList<>();

        employees.add("Rahul");
        employees.add("Saran");
        employees.add("Kiran");
        employees.add("Priya");
        employees.add("Sneha");
        employees.add("Arun");
        employees.add("Ravi");
        employees.add("Manoj");
        employees.add("Divya");
        employees.add("Pavan");

        System.out.println("Attendance List: " + employees);

        employees.add("Vijay");
        System.out.println("After Adding Employee: " + employees);

        employees.remove("Arun");
        System.out.println("After Removing Absent Employee: " + employees);

        System.out.println("Is Priya Present? " + employees.contains("Priya"));

        System.out.println("Total Present Employees: " + employees.size());

        System.out.println("Employees in Reverse Order:");

        for (int i = employees.size() - 1; i >= 0; i--) {
            System.out.println(employees.get(i));
        }
    }
}