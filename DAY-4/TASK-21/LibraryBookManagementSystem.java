import java.util.ArrayList;
import java.util.Collections;

public class LibraryBookManagementSystem {
    public static void main(String[] args) {

        ArrayList<String> books = new ArrayList<>();

        books.add("Java Programming");
        books.add("Python Basics");
        books.add("Data Structures");
        books.add("Machine Learning");
        books.add("Database Management");
        books.add("Web Development");
        books.add("Operating Systems");
        books.add("Computer Networks");
        books.add("Artificial Intelligence");
        books.add("Software Engineering");

        System.out.println("Initial Book List: " + books);

        books.add("Cloud Computing");
        System.out.println("\nAfter Adding New Book: " + books);

        books.remove("Python Basics");
        System.out.println("After Removing Damaged Book: " + books);

        books.set(2, "Advanced Data Structures");
        System.out.println("After Updating Book Title: " + books);

        System.out.println("Is Java Programming Available? "
                + books.contains("Java Programming"));

        System.out.println("\nAvailable Books:");

        for (String book : books) {
            System.out.println(book);
        }

        System.out.println("\nTotal Number of Books: " + books.size());

        Collections.reverse(books);

        System.out.println("\nBooks in Reverse Order:");

        for (String book : books) {
            System.out.println(book);
        }
    }
}