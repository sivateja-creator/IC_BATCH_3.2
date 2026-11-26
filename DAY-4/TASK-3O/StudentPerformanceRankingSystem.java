import java.util.*;

public class StudentPerformanceRankingSystem {
    public static void main(String[] args) {
        HashMap<String, Integer> students = new HashMap<>();
        TreeSet<Integer> marksSet = new TreeSet<>();

        students.put("Rahul", 85);
        students.put("Priya", 92);
        students.put("Kiran", 76);
        students.put("Sneha", 95);
        students.put("Arun", 68);
        students.put("Vijay", 88);
        students.put("Saran", 92);
        students.put("Divya", 55);
        students.put("Manoj", 72);
        students.put("Pavan", 40);

        marksSet.addAll(students.values());

        System.out.println("Student Marks:");
        int total = 0;
        int passed = 0;
        int failed = 0;
        int highest = marksSet.last();

        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            total += entry.getValue();

            if (entry.getValue() >= 40)
                passed++;
            else
                failed++;
        }

        System.out.println("\nHighest Marks: " + marksSet.last());
        System.out.println("Lowest Marks: " + marksSet.first());

        System.out.println("\nUnique Marks in Ascending Order:");
        System.out.println(marksSet);

        System.out.println("\nStudents Scoring Above 80:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            if (entry.getValue() > 80)
                System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nClass Average: " + (double) total / students.size());

        System.out.println("\nTop Performing Student(s):");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            if (entry.getValue() == highest)
                System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nPassed Students: " + passed);
        System.out.println("Failed Students: " + failed);

        System.out.println("Total Students: " + students.size());
    }
}