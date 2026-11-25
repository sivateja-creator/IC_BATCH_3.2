public class InputValidator {
    String userInput = " ";

    void validateInput() {
        if (userInput.isBlank()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("Valid Input");
        }
    }

    public static void main(String[] args) {
        InputValidator i = new InputValidator();

        i.validateInput();

        i.userInput = "";
        i.validateInput();

        i.userInput = "Java Programming";
        i.validateInput();
    }
}