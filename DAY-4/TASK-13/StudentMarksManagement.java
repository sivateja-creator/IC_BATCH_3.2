import java.util.HashMap;

public class StudentMarksManagement {
    public static void main(String[] args) {

        HashMap<String, Integer> students = new HashMap<>();

        students.put("Rahul", 85);
        students.put("Saran", 90);
        students.put("Kiran", 78);
        students.put("Priya", 95);
        students.put("Sneha", 88);
        students.put("Arun", 76);
        students.put("Ravi", 82);
        students.put("Manoj", 91);
        students.put("Divya", 89);
        students.put("Pavan", 80);

        System.out.println("Student Records: " + students);

        students.put("Rahul", 92);
        System.out.println("After Updating Rahul's Marks: " + students.get("Rahul"));

        System.out.println("Saran's Marks: " + students.get("Saran"));

        System.out.println("Is Priya Available? " + students.containsKey("Priya"));

        students.remove("Arun");
        System.out.println("After Removing Arun: " + students);

        System.out.println("All Student Names and Marks:");

        for (String name : students.keySet()) {
            System.out.println(name + " : " + students.get(name));
        }

        int total = 0;

        for (int mark : students.values()) {
            total += mark;
        }

        double average = (double) total / students.size();

        System.out.println("Average Marks: " + average);
    }
}