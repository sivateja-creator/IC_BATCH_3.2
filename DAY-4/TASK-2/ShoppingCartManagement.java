import java.util.ArrayList;

public class ShoppingCartManagement {
    public static void main(String[] args) {

        ArrayList<String> products = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        products.add("Laptop");
        quantities.add(1);

        products.add("Mobile");
        quantities.add(2);

        products.add("Headphones");
        quantities.add(1);

        products.add("Keyboard");
        quantities.add(3);

        products.add("Mouse");
        quantities.add(2);

        System.out.println("Shopping Cart: " + products);

        products.remove("Headphones");
        quantities.remove(2);
        System.out.println("After Removing Product: " + products);

        quantities.set(1, 5);
        System.out.println("Updated Quantity of Mobile: " + quantities.get(1));

        System.out.println("Is Laptop Available? " + products.contains("Laptop"));

        System.out.println("Cart Products and Quantities:");

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i) + " - Quantity: " + quantities.get(i));
        }

        int totalProducts = 0;

        for (int quantity : quantities) {
            totalProducts += quantity;
        }

        System.out.println("Total Number of Products: " + totalProducts);

        products.clear();
        quantities.clear();

        System.out.println("Cart After Checkout: " + products);
    }
}