public class WordAnalyzer {
    String word = "banana";

    void analyzeWord() {
        System.out.println("First occurrence of a: " + word.indexOf('a'));
        System.out.println("Last occurrence of a: " + word.lastIndexOf('a'));

        System.out.println("First occurrence of n: " + word.indexOf('n'));
        System.out.println("Last occurrence of n: " + word.lastIndexOf('n'));
    }

    public static void main(String[] args) {
        WordAnalyzer w = new WordAnalyzer();
        w.analyzeWord();
    }
}