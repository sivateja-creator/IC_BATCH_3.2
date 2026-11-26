import java.util.TreeSet;

public class SortedEmployeeIDManagement {
    public static void main(String[] args) {

        TreeSet<Integer> employeeIds = new TreeSet<>();

        employeeIds.add(105);
        employeeIds.add(102);
        employeeIds.add(110);
        employeeIds.add(101);
        employeeIds.add(108);
        employeeIds.add(104);
        employeeIds.add(107);
        employeeIds.add(103);
        employeeIds.add(109);
        employeeIds.add(106);

        System.out.println("Employee IDs: " + employeeIds);

        employeeIds.add(111);
        System.out.println("After Adding New ID: " + employeeIds);

        employeeIds.remove(105);
        System.out.println("After Removing ID: " + employeeIds);

        System.out.println("Smallest Employee ID: " + employeeIds.first());
        System.out.println("Largest Employee ID: " + employeeIds.last());

        System.out.println("Next Higher ID than 106: " + employeeIds.higher(106));
        System.out.println("Next Lower ID than 106: " + employeeIds.lower(106));

        System.out.println("IDs Below 106: " + employeeIds.headSet(106));

        System.out.println("IDs From 106 Onwards: " + employeeIds.tailSet(106));

        System.out.println("IDs Between 103 and 109: " + employeeIds.subSet(103, 109));
    }
}