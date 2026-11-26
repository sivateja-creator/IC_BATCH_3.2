import java.util.LinkedHashSet;

public class RecentlyViewedProducts {
    public static void main(String[] args) {

        LinkedHashSet<String> products = new LinkedHashSet<>();

        products.add("Laptop");
        products.add("Mobile");
        products.add("Headphones");
        products.add("Keyboard");
        products.add("Mouse");

        System.out.println("Recently Viewed Products: " + products);

        products.add("Smart Watch");
        products.add("Laptop");
        products.add("Camera");

        System.out.println("After Viewing New Products: " + products);

        System.out.println("Mobile Viewed: " + products.contains("Mobile"));

        products.remove("Keyboard");

        System.out.println("After Removing Keyboard: " + products);

        System.out.println("Total Unique Products: " + products.size());
    }
}