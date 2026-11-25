public class TextConverter {
    String message = "Welcome to Java Programming";

    void convertText() {
        System.out.println("Original Message: " + message);
        System.out.println("Uppercase: " + message.toUpperCase());
        System.out.println("Lowercase: " + message.toLowerCase());
    }

    public static void main(String[] args) {
        TextConverter t = new TextConverter();
        t.convertText();
    }
}