import java.util.LinkedList;

public class BrowserHistoryManagement {
    public static void main(String[] args) {

        LinkedList<String> history = new LinkedList<>();

        history.add("https://www.google.com");
        history.add("https://www.youtube.com");
        history.add("https://www.github.com");
        history.add("https://www.instagram.com");
        history.add("https://www.leetcode.com");

        System.out.println("Browsing History: " + history);

        history.add("https://www.linkedin.com");
        System.out.println("After Visiting New Website: " + history);

        history.removeLast();
        System.out.println("After Removing Last Visited Website: " + history);

        System.out.println("First Visited Website: " + history.getFirst());
        System.out.println("Last Visited Website: " + history.getLast());

        System.out.println("Was YouTube Visited? " + history.contains("https://www.youtube.com"));

        history.clear();
        System.out.println("After Clearing History: " + history);
    }
}