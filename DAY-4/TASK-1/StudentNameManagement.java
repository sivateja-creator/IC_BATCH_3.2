import java.util.ArrayList;

public class StudentNameManagement {
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        students.add("Rahul");
        students.add("Saran");
        students.add("Kiran");
        students.add("Arun");
        students.add("Priya");
        students.add("Sneha");
        students.add("Ravi");
        students.add("Manoj");
        students.add("Divya");
        students.add("Pavan");

        System.out.println("All Student Names: " + students);

        students.add(2, "Vijay");
        System.out.println("After Adding Student: " + students);

        students.remove("Arun");
        System.out.println("After Removing Student: " + students);

        students.set(0, "Siva");
        System.out.println("After Updating Student: " + students);

        System.out.println("Is Priya Available? " + students.contains("Priya"));

        System.out.println("Student at Index 2: " + students.get(2));

        System.out.println("Total Number of Students: " + students.size());
    }
}