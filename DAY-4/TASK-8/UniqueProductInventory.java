import java.util.HashSet;

public class UniqueProductInventory {
    public static void main(String[] args) {

        HashSet<String> products = new HashSet<>();

        products.add("Laptop");
        products.add("Mobile");
        products.add("Keyboard");
        products.add("Mouse");
        products.add("Headphones");
        products.add("Monitor");
        products.add("Printer");
        products.add("Tablet");
        products.add("Speaker");
        products.add("Webcam");

        System.out.println("Product Inventory: " + products);

        products.add("Smart Watch");
        System.out.println("After Adding New Product: " + products);

        products.add("Laptop");
        System.out.println("After Adding Duplicate Product: " + products);

        products.remove("Printer");
        System.out.println("After Removing Discontinued Product: " + products);

        System.out.println("Is Mobile Available? " + products.contains("Mobile"));

        System.out.println("Total Unique Products: " + products.size());
    }
}