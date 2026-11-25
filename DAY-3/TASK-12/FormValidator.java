public class FormValidator {
    String name = "";

    void validateName() {
        if (name.isEmpty()) {
            System.out.println("Name is required");
        } else {
            System.out.println("Name submitted successfully");
        }
    }

    public static void main(String[] args) {
        FormValidator f = new FormValidator();
        f.validateName();

        f.name = "Saran";
        f.validateName();
    }
}