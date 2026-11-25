public class EmailChecker {
    String email = "student@gmail.com";

    void checkEmail() {
        if (email.contains("@")) {
            System.out.println("Email contains @");
        } else {
            System.out.println("Email does not contain @");
        }

        if (email.contains("gmail")) {
            System.out.println("Email contains gmail");
        } else {
            System.out.println("Email does not contain gmail");
        }
    }

    public static void main(String[] args) {
        EmailChecker e = new EmailChecker();
        e.checkEmail();

        e.email = "student@yahoo.com";
        e.checkEmail();
    }
}