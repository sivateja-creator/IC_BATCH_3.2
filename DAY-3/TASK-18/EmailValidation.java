public class EmailValidation {
    String email = "student@gmail.com";

    void validateEmail() {
        if (!email.isEmpty() &&
            email.contains("@") &&
            email.endsWith(".com") &&
            email.startsWith("student")) {

            System.out.println("Valid Email");
        } else {
            System.out.println("Invalid Email");
        }
    }

    public static void main(String[] args) {
        EmailValidation e = new EmailValidation();

        e.validateEmail();

        e.email = "student@yahoo.com";
        e.validateEmail();

        e.email = "user@gmail.com";
        e.validateEmail();

        e.email = "";
        e.validateEmail();
    }
}