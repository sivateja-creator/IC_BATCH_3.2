public class CharacterFinder {
    String word = "Programming";

    void findCharacters() {
        System.out.println("First occurrence of g: " + word.indexOf('g'));
        System.out.println("Position of m: " + word.indexOf('m'));
        System.out.println("Position of z: " + word.indexOf('z'));
    }

    public static void main(String[] args) {
        CharacterFinder c = new CharacterFinder();
        c.findCharacters();
    }
}