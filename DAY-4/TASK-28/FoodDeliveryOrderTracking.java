import java.util.LinkedHashMap;
import java.util.Map;

public class FoodDeliveryOrderTracking {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> orders = new LinkedHashMap<>();

        orders.put(1001, "Preparing");
        orders.put(1002, "Packed");
        orders.put(1003, "Out for Delivery");
        orders.put(1004, "Preparing");
        orders.put(1005, "Delivered");

        System.out.println("All Customer Orders: " + orders);

        orders.put(1001, "Packed");
        orders.put(1002, "Out for Delivery");
        orders.put(1003, "Delivered");

        System.out.println("\nAfter Updating Order Status:");
        System.out.println(orders);

        int searchId = 1002;

        if (orders.containsKey(searchId)) {
            System.out.println("\nOrder " + searchId
                    + " Status: " + orders.get(searchId));
        } else {
            System.out.println("Order Not Found!");
        }

        orders.remove(1004);

        System.out.println("\nAfter Cancelling Order 1004:");
        System.out.println(orders);

        System.out.println("\nOrders in Received Order:");

        for (Map.Entry<Integer, String> entry : orders.entrySet()) {
            System.out.println("Order ID: " + entry.getKey()
                    + " | Status: " + entry.getValue());
        }

        int preparing = 0;
        int packed = 0;
        int outForDelivery = 0;
        int delivered = 0;

        for (String status : orders.values()) {
            switch (status) {
                case "Preparing":
                    preparing++;
                    break;
                case "Packed":
                    packed++;
                    break;
                case "Out for Delivery":
                    outForDelivery++;
                    break;
                case "Delivered":
                    delivered++;
                    break;
            }
        }

        System.out.println("\nOrder Status Count:");
        System.out.println("Preparing: " + preparing);
        System.out.println("Packed: " + packed);
        System.out.println("Out for Delivery: " + outForDelivery);
        System.out.println("Delivered: " + delivered);

        System.out.println("Total Active Orders: "
                + orders.getOrDefault(1001, "Not Found"));
    }
}