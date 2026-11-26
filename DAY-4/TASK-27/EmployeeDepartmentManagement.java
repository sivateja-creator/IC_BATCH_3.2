import java.util.TreeMap;

public class EmployeeDepartmentManagement {
    public static void main(String[] args) {

        TreeMap<Integer, String> employees = new TreeMap<>();

        employees.put(105, "HR");
        employees.put(102, "IT");
        employees.put(108, "Finance");
        employees.put(101, "Marketing");
        employees.put(104, "Development");
        employees.put(103, "Testing");
        employees.put(107, "Sales");
        employees.put(106, "Support");

        System.out.println("Employee Records: " + employees);

        employees.put(105, "Development");

        System.out.println("Updated Employee 105: " + employees.get(105));

        System.out.println("Employee 103 Department: " + employees.get(103));

        System.out.println("Employee 106 Exists: " + employees.containsKey(106));

        employees.remove(108);

        System.out.println("After Removing Employee 108: " + employees);

        System.out.println("First Employee ID: " + employees.firstKey());
        System.out.println("Last Employee ID: " + employees.lastKey());

        System.out.println("Descending Order: " + employees.descendingMap());

        System.out.println("Employees from ID 102 to 106: "
                + employees.subMap(102, true, 106, true));
    }
}