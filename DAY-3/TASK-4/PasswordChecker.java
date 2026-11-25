public class PasswordChecker {
    String password = "Java@123";
    String confirmPassword = "Java@123";

    void checkPassword() {
        if (password.equals(confirmPassword)) {
            System.out.println("Password Matched");
        } else {
            System.out.println("Password Mismatch");
        }
    }

    public static void main(String[] args) {
        PasswordChecker p = new PasswordChecker();
        p.checkPassword();

        p.confirmPassword = "Java123";
        p.checkPassword();
    }
}