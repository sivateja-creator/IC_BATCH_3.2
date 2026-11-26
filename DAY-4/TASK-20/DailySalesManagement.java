import java.util.LinkedHashMap;
import java.util.Map;

public class DailySalesManagement {
    public static void main(String[] args) {

        LinkedHashMap<String, Integer> sales = new LinkedHashMap<>();

        sales.put("Laptop", 10);
        sales.put("Mobile", 25);
        sales.put("Keyboard", 15);
        sales.put("Mouse", 20);
        sales.put("Headphones", 12);
        sales.put("Monitor", 8);
        sales.put("Printer", 5);
        sales.put("Tablet", 18);
        sales.put("Smart Watch", 14);
        sales.put("Speaker", 9);

        System.out.println("Initial Sales: " + sales);

        sales.put("Laptop", 15);
        System.out.println("Updated Laptop Sales: " + sales.get("Laptop"));

        sales.put("Camera", 11);

        System.out.println("\nDaily Sales Report:");

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println("Product: " + entry.getKey()
                    + " Sales Quantity: " + entry.getValue());
        }

        int totalSales = 0;

        for (int quantity : sales.values()) {
            totalSales += quantity;
        }

        System.out.println("\nTotal Products Sold: " + totalSales);

        String highestProduct = "";
        int highestSales = 0;

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > highestSales) {
                highestSales = entry.getValue();
                highestProduct = entry.getKey();
            }
        }

        System.out.println("Product with Highest Sales: " + highestProduct);
        System.out.println("Highest Sales Quantity: " + highestSales);

        System.out.println("\nSales Report in Insertion Order:");

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}