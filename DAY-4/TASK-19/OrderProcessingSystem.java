import java.util.LinkedHashMap;
import java.util.Map;

public class OrderProcessingSystem {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> orders = new LinkedHashMap<>();

        orders.put(1001, "Rahul");
        orders.put(1002, "Priya");
        orders.put(1003, "Kiran");
        orders.put(1004, "Sneha");
        orders.put(1005, "Arun");
        orders.put(1006, "Ravi");
        orders.put(1007, "Manoj");
        orders.put(1008, "Divya");
        orders.put(1009, "Pavan");
        orders.put(1010, "Vijay");

        System.out.println("All Orders: " + orders);

        orders.put(1003, "Karthik");
        System.out.println("Updated Order 1003: " + orders.get(1003));

        orders.put(1011, "Suresh");
        System.out.println("After Adding New Order: " + orders);

        System.out.println("Search Order 1005: " + orders.get(1005));

        System.out.println("Does Order 1007 Exist? "
                + orders.containsKey(1007));

        orders.remove(1004);
        System.out.println("After Cancelling Order 1004: " + orders);

        System.out.println("\nAll Orders in Received Order:");

        for (Map.Entry<Integer, String> entry : orders.entrySet()) {
            System.out.println("Order ID: " + entry.getKey()
                    + " Customer Name: " + entry.getValue());
        }
    }
}