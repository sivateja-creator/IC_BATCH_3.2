import java.util.HashSet;

public class UniqueStudentRegistration {
    public static void main(String[] args) {

        HashSet<Integer> studentIds = new HashSet<>();

        studentIds.add(101);
        studentIds.add(102);
        studentIds.add(103);
        studentIds.add(104);
        studentIds.add(105);
        studentIds.add(106);
        studentIds.add(107);
        studentIds.add(108);
        studentIds.add(109);
        studentIds.add(110);

        System.out.println("Registered Student IDs: " + studentIds);

        studentIds.add(111);
        System.out.println("After Adding New ID: " + studentIds);

        studentIds.add(105);
        System.out.println("After Adding Duplicate ID: " + studentIds);

        studentIds.remove(103);
        System.out.println("After Removing ID: " + studentIds);

        System.out.println("Is ID 105 Registered? " + studentIds.contains(105));

        System.out.println("Total Unique Registrations: " + studentIds.size());
    }
}