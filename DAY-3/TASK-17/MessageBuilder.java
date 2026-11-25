public class MessageBuilder {
    String firstName = "Java";
    String lastName = "Developer";

    void displayMessage() {
        String fullName = firstName.concat(" ").concat(lastName);

        System.out.println("Welcome, " + fullName);
    }

    public static void main(String[] args) {
        MessageBuilder m = new MessageBuilder();
        m.displayMessage();
    }
}