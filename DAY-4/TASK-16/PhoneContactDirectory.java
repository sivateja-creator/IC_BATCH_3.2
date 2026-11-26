import java.util.HashMap;
import java.util.Map;

public class PhoneContactDirectory {
    public static void main(String[] args) {

        HashMap<String, String> contacts = new HashMap<>();

        contacts.put("Rahul", "9876543210");
        contacts.put("Saran", "9876543211");
        contacts.put("Kiran", "9876543212");
        contacts.put("Priya", "9876543213");
        contacts.put("Sneha", "9876543214");
        contacts.put("Arun", "9876543215");
        contacts.put("Ravi", "9876543216");
        contacts.put("Manoj", "9876543217");
        contacts.put("Divya", "9876543218");
        contacts.put("Pavan", "9876543219");

        System.out.println("All Contacts: " + contacts);

        contacts.put("Rahul", "9123456780");
        System.out.println("Updated Rahul's Number: " + contacts.get("Rahul"));

        System.out.println("Priya's Number: " + contacts.get("Priya"));

        System.out.println("Is Kiran Available? " + contacts.containsKey("Kiran"));

        System.out.println("Is Phone Number Saved? "
                + contacts.containsValue("9876543213"));

        contacts.remove("Arun");
        System.out.println("After Removing Arun: " + contacts);

        System.out.println("\nAll Contact Details:");

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println("Name: " + entry.getKey()
                    + " Phone Number: " + entry.getValue());
        }
    }
}