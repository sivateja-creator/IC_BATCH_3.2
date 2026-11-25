public class InputCleaner {
    String username = " JavaDeveloper ";

    void cleanInput() {
        System.out.println("Original Username: '" + username + "'");
        System.out.println("Original Length: " + username.length());

        String cleanedUsername = username.trim();

        System.out.println("Cleaned Username: '" + cleanedUsername + "'");
        System.out.println("Cleaned Length: " + cleanedUsername.length());
    }

    public static void main(String[] args) {
        InputCleaner i = new InputCleaner();
        i.cleanInput();
    }
}