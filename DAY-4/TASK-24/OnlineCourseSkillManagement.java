import java.util.TreeSet;

public class OnlineCourseSkillManagement {
    public static void main(String[] args) {

        TreeSet<String> skills = new TreeSet<>();

        skills.add("Java");
        skills.add("Python");
        skills.add("React");
        skills.add("SQL");
        skills.add("MongoDB");

        System.out.println("Available Skills: " + skills);

        skills.add("HTML");
        skills.add("JavaScript");
        skills.add("Java");

        System.out.println("After Adding New Skills: " + skills);

        skills.remove("SQL");

        System.out.println("After Removing SQL: " + skills);

        System.out.println("Java Available: " + skills.contains("Java"));

        System.out.println("First Skill: " + skills.first());
        System.out.println("Last Skill: " + skills.last());

        System.out.println("Descending Order: " + skills.descendingSet());
    }
}