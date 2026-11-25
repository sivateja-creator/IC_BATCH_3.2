public class NameExtractor {
    String fullName = "Java Full Stack Developer";

    void extractWords() {
        System.out.println("First Word: " + fullName.substring(0, 4));
        System.out.println("Second Word: " + fullName.substring(5, 9));
        System.out.println("Remaining Text: " + fullName.substring(10));
    }

    public static void main(String[] args) {
        NameExtractor n = new NameExtractor();
        n.extractWords();
    }
}