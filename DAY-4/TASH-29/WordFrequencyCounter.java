import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> words = new HashMap<>();

        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine().toLowerCase();

        paragraph = paragraph.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] arr = paragraph.split("\\s+");

        for (String word : arr) {
            if (!word.isEmpty()) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("\nWord Frequencies:");
        String mostFrequent = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());

            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        System.out.println("\nMost Frequent Word: " + mostFrequent);
        System.out.println("Occurrences: " + maxCount);
        System.out.println("Unique Words: " + words.size());

        sc.close();
    }
}