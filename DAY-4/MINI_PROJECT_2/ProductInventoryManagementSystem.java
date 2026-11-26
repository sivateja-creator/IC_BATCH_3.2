import java.util.*;

public class ProductInventoryManagementSystem {

    static HashMap<Integer, Integer> inventory = new HashMap<>();
    static HashMap<Integer, String> productNames = new HashMap<>();
    static HashMap<Integer, String> productCategories = new HashMap<>();
    static HashMap<Integer, Double> productPrices = new HashMap<>();

    static HashSet<String> categories = new HashSet<>();
    static LinkedHashSet<String> recentlyAdded = new LinkedHashSet<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("       PRODUCT INVENTORY SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product Quantity");
            System.out.println("5. Sell Product");
            System.out.println("6. Remove Product");
            System.out.println("7. Add Product Category");
            System.out.println("8. Display Unique Categories");
            System.out.println("9. Display Sorted Categories");
            System.out.println("10. Display Recently Added Products");
            System.out.println("11. Generate Inventory Report");
            System.out.println("12. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateQuantity();
                    break;

                case 5:
                    sellProduct();
                    break;

                case 6:
                    removeProduct();
                    break;

                case 7:
                    addCategory();
                    break;

                case 8:
                    displayCategories();
                    break;

                case 9:
                    displaySortedCategories();
                    break;

                case 10:
                    displayRecentlyAdded();
                    break;

                case 11:
                    generateReport();
                    break;

                case 12:
                    System.out.println("Thank You! Application Closed.");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 12);

        sc.close();
    }

    static void addProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (inventory.containsKey(id)) {
            System.out.println("Product ID Already Exists!");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Available Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (price < 0 || quantity < 0) {
            System.out.println("Price and Quantity Cannot Be Negative!");
            return;
        }

        inventory.put(id, quantity);
        productNames.put(id, name);
        productCategories.put(id, category);
        productPrices.put(id, price);

        categories.add(category);
        recentlyAdded.add(name);

        System.out.println("Product Added Successfully!");
    }

    static void displayProducts() {

        if (inventory.isEmpty()) {
            System.out.println("No Products Available!");
            return;
        }

        System.out.println("\n---------- PRODUCT INVENTORY ----------");

        System.out.printf("%-10s %-15s %-15s %-12s %-10s%n",
                "ID", "Product", "Category", "Price", "Quantity");

        for (int id : inventory.keySet()) {

            System.out.printf("%-10d %-15s %-15s %-12.2f %-10d%n",
                    id,
                    productNames.get(id),
                    productCategories.get(id),
                    productPrices.get(id),
                    inventory.get(id));
        }

        System.out.println("----------------------------------------");
        System.out.println("Total Products: " + inventory.size());
    }

    static void searchProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (inventory.containsKey(id)) {

            System.out.println("\nProduct Found!");
            System.out.println("Product ID: " + id);
            System.out.println("Product Name: " + productNames.get(id));
            System.out.println("Category: " + productCategories.get(id));
            System.out.println("Price: " + productPrices.get(id));
            System.out.println("Available Quantity: "
                    + inventory.getOrDefault(id, 0));

        } else {
            System.out.println("Product Not Found!");
        }
    }

    static void updateQuantity() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (!inventory.containsKey(id)) {
            System.out.println("Product Not Found!");
            return;
        }

        System.out.print("Enter Additional Quantity: ");
        int quantity = sc.nextInt();

        if (quantity <= 0) {
            System.out.println("Enter a Valid Positive Quantity!");
            return;
        }

        int current = inventory.getOrDefault(id, 0);

        inventory.put(id, current + quantity);

        System.out.println("Stock Updated Successfully!");
        System.out.println("Available Quantity: " + inventory.get(id));
    }

    static void sellProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (!inventory.containsKey(id)) {
            System.out.println("Product Not Found!");
            return;
        }

        System.out.print("Enter Quantity Sold: ");
        int quantity = sc.nextInt();

        int available = inventory.getOrDefault(id, 0);

        if (quantity <= 0) {
            System.out.println("Enter a Valid Positive Quantity!");
        } else if (quantity > available) {
            System.out.println("Insufficient Stock!");
        } else {

            inventory.put(id, available - quantity);

            System.out.println("Sale Completed Successfully!");
            System.out.println("Product ID: " + id);
            System.out.println("Remaining Quantity: " + inventory.get(id));
        }
    }

    static void removeProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (!inventory.containsKey(id)) {
            System.out.println("Product Not Found!");
            return;
        }

        String name = productNames.get(id);
        String category = productCategories.get(id);

        inventory.remove(id);
        productNames.remove(id);
        productPrices.remove(id);
        productCategories.remove(id);

        if (!productNames.containsValue(name)) {
            recentlyAdded.remove(name);
        }

        if (!productCategories.containsValue(category)) {
            categories.remove(category);
        }

        System.out.println("Product Removed Successfully!");
    }

    static void addCategory() {

        System.out.print("Enter Category Name: ");
        String category = sc.nextLine();

        if (categories.add(category)) {
            System.out.println("Category Added Successfully!");
        } else {
            System.out.println("Category Already Exists!");
        }
    }

    static void displayCategories() {

        System.out.println("\n--------- PRODUCT CATEGORIES ---------");

        for (String category : categories) {
            System.out.println(category);
        }

        System.out.println("Total Unique Categories: " + categories.size());
        System.out.println("--------------------------------------");
    }

    static void displaySortedCategories() {

        TreeSet<String> sortedCategories = new TreeSet<>(categories);

        System.out.println("\n--------- SORTED CATEGORIES ----------");

        System.out.println("Ascending Order: " + sortedCategories);

        if (!sortedCategories.isEmpty()) {
            System.out.println("First Category: " + sortedCategories.first());
            System.out.println("Last Category: " + sortedCategories.last());
            System.out.println("Descending Order: "
                    + sortedCategories.descendingSet());
        } else {
            System.out.println("No Categories Available!");
        }

        System.out.println("--------------------------------------");
    }

    static void displayRecentlyAdded() {

        System.out.println("\n------ RECENTLY ADDED PRODUCTS ------");

        if (recentlyAdded.isEmpty()) {
            System.out.println("No Recently Added Products!");
        } else {
            for (String product : recentlyAdded) {
                System.out.println(product);
            }
        }

        System.out.println("Total Unique Products: " + recentlyAdded.size());
    }

    static void generateReport() {

        int totalQuantity = 0;
        int highestQuantity = -1;
        int highestProductId = -1;

        System.out.println("\n========== INVENTORY REPORT ==========");

        if (inventory.isEmpty()) {
            System.out.println("No Products Available!");
            System.out.println("Total Products: 0");
            System.out.println("Total Available Units: 0");
            System.out.println("======================================");
            return;
        }

        System.out.println("\nProducts with Quantity Below 5:");

        boolean found = false;

        for (int id : inventory.keySet()) {

            int quantity = inventory.get(id);

            totalQuantity += quantity;

            if (quantity < 5) {
                System.out.println(productNames.get(id)
                        + " - Quantity: " + quantity);
                found = true;
            }

            if (quantity > highestQuantity) {
                highestQuantity = quantity;
                highestProductId = id;
            }
        }

        if (!found) {
            System.out.println("No Low Stock Products!");
        }

        System.out.println("\nTotal Products: " + inventory.size());
        System.out.println("Total Available Units: " + totalQuantity);

        System.out.println("Highest Stock Product: "
                + productNames.get(highestProductId));

        System.out.println("Highest Available Quantity: " + highestQuantity);

        System.out.println("Unique Categories: " + categories);
        System.out.println("Total Unique Categories: " + categories.size());

        System.out.println("======================================");
    }
}