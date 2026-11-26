import java.util.LinkedHashSet;

public class RecentlyAddedContacts {
    public static void main(String[] args) {

        LinkedHashSet<String> contacts = new LinkedHashSet<>();

        contacts.add("Rahul");
        contacts.add("Saran");
        contacts.add("Kiran");
        contacts.add("Priya");
        contacts.add("Sneha");
        contacts.add("Arun");
        contacts.add("Ravi");
        contacts.add("Manoj");
        contacts.add("Divya");
        contacts.add("Pavan");

        System.out.println("Contact List: " + contacts);

        contacts.add("Vijay");
        System.out.println("After Adding New Contact: " + contacts);

        contacts.add("Rahul");
        System.out.println("After Adding Duplicate Contact: " + contacts);

        contacts.remove("Arun");
        System.out.println("After Removing Contact: " + contacts);

        System.out.println("Is Priya Available? " + contacts.contains("Priya"));

        System.out.println("Contacts in Insertion Order:");

        for (String contact : contacts) {
            System.out.println(contact);
        }
    }
}