import java.util.HashSet;

public class CollegeEventRegistrationSystem {
    public static void main(String[] args) {

        HashSet<Integer> event1 = new HashSet<>();
        HashSet<Integer> event2 = new HashSet<>();

        event1.add(101);
        event1.add(102);
        event1.add(103);
        event1.add(104);
        event1.add(105);

        event1.add(106);
        event1.add(103);

        event1.remove(104);

        System.out.println("Event 1 Registrations: " + event1);
        System.out.println("Student 102 Registered: " + event1.contains(102));
        System.out.println("Total Registrations: " + event1.size());

        event2.add(103);
        event2.add(105);
        event2.add(106);
        event2.add(107);
        event2.add(108);

        System.out.println("\nEvent 2 Registrations: " + event2);

        HashSet<Integer> commonStudents = new HashSet<>(event1);
        commonStudents.retainAll(event2);

        System.out.println("\nStudents Registered for Both Events: " + commonStudents);

        HashSet<Integer> allStudents = new HashSet<>(event1);
        allStudents.addAll(event2);

        System.out.println("All Unique Registered Students: " + allStudents);
        System.out.println("Total Unique Students: " + allStudents.size());
    }
}