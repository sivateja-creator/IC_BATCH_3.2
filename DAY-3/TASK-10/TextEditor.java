public class TextEditor {
    String sentence = "I love Python Programming";

    void editText() {
        System.out.println("Original Sentence: " + sentence);

        String newSentence = sentence.replace("Python", "Java");
        System.out.println("After Replacing Python: " + newSentence);

        String modifiedSentence = sentence.replace('o', '0');
        System.out.println("After Replacing o: " + modifiedSentence);
    }

    public static void main(String[] args) {
        TextEditor t = new TextEditor();
        t.editText();
    }
}