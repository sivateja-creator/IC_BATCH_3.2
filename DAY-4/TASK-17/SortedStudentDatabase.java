import java.util.TreeMap;
import java.util.Map;

public class SortedStudentDatabase {
    public static void main(String[] args) {

        TreeMap<Integer, String> students = new TreeMap<>();

        students.put(105, "Rahul");
        students.put(102, "Priya");
        students.put(108, "Kiran");
        students.put(101, "Saran");
        students.put(106, "Sneha");
        students.put(104, "Arun");
        students.put(110, "Ravi");
        students.put(103, "Manoj");
        students.put(109, "Divya");
        students.put(107, "Pavan");

        System.out.println("Student Records: " + students);

        students.put(105, "Vijay");
        System.out.println("Updated Student 105: " + students.get(105));

        students.remove(108);
        System.out.println("After Removing Student 108: " + students);

        System.out.println("First Roll Number: " + students.firstKey());
        System.out.println("Last Roll Number: " + students.lastKey());

        System.out.println("\nRecords in Ascending Order:");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nRecords in Descending Order:");

        for (Map.Entry<Integer, String> entry : students.descendingMap().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nStudent Records from Roll Number 103 to 107:");

        for (Map.Entry<Integer, String> entry : students.subMap(103, true, 107, true).entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}