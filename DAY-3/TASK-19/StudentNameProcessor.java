public class StudentNameProcessor {
    String fullName = " rahul kumar ";

    void processName() {
        String cleanedName = fullName.trim();
        String upperName = cleanedName.toUpperCase();

        int spacePosition = cleanedName.indexOf(" ");

        String firstName = cleanedName.substring(0, spacePosition);
        String lastName = cleanedName.substring(spacePosition + 1);

        int characterCount = cleanedName.length();

        System.out.println("Original Name: '" + fullName + "'");
        System.out.println("Cleaned Name: " + cleanedName);
        System.out.println("Uppercase Name: " + upperName);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Character Count: " + characterCount);

        if (upperName.startsWith("RAHUL")) {
            System.out.println("Validation: Valid Name");
        } else {
            System.out.println("Validation: Invalid Name");
        }
    }

    public static void main(String[] args) {
        StudentNameProcessor s = new StudentNameProcessor();
        s.processName();
    }
}