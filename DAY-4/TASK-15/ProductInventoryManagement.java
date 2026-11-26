import java.util.HashMap;
import java.util.Map;

public class ProductInventoryManagement {
    public static void main(String[] args) {

        HashMap<Integer, Integer> products = new HashMap<>();

        products.put(101, 10);
        products.put(102, 8);
        products.put(103, 3);
        products.put(104, 15);
        products.put(105, 5);
        products.put(106, 2);
        products.put(107, 12);
        products.put(108, 7);
        products.put(109, 0);
        products.put(110, 20);

        products.put(111, 6);

        products.put(102, 12);

        int soldQuantity = 3;
        int currentQuantity = products.getOrDefault(101, 0);
        products.put(101, currentQuantity - soldQuantity);

        System.out.println("Quantity of Product 105: " + products.get(105));

        System.out.println("All Product Details:");

        for (Map.Entry<Integer, Integer> entry : products.entrySet()) {
            System.out.println("Product ID: " + entry.getKey()
                    + " Quantity: " + entry.getValue());
        }

        System.out.println("Products with Quantity Below 5:");

        for (Map.Entry<Integer, Integer> entry : products.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println("Product ID: " + entry.getKey()
                        + " Quantity: " + entry.getValue());
            }
        }

        products.remove(109);

        System.out.println("After Removing Out-of-Stock Products: " + products);
    }
}