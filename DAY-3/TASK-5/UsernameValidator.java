public class UsernameValidator {
    String username = "Admin";
    String enteredUsername = "ADMIN";

    void validateUsername() {
        if (username.equalsIgnoreCase(enteredUsername)) {
            System.out.println("Valid Username");
        } else {
            System.out.println("Invalid Username");
        }
    }

    public static void main(String[] args) {
        UsernameValidator u = new UsernameValidator();
        u.validateUsername();
    }
}
