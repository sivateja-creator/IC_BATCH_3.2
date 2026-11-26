import java.util.LinkedList;

public class CustomerServiceQueueManagement {
    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.addLast("Rahul");
        queue.addLast("Priya");
        queue.addLast("Kiran");
        queue.addLast("Sneha");
        queue.addLast("Arun");

        System.out.println("Initial Customer Queue: " + queue);

        queue.addFirst("Emergency Customer");
        System.out.println("\nAfter Adding Emergency Customer: " + queue);

        System.out.println("\nWaiting Customers:");

        for (String customer : queue) {
            System.out.println(customer);
        }

        System.out.println("\nNext Customer to be Served: " + queue.peek());

        System.out.println("\nServing Customer: " + queue.poll());

        System.out.println("Updated Queue: " + queue);

        queue.remove("Kiran");
        System.out.println("\nAfter Removing Kiran: " + queue);

        System.out.println("Total Waiting Customers: " + queue.size());

        System.out.println("\nServing All Remaining Customers:");

        while (!queue.isEmpty()) {
            System.out.println("Serving: " + queue.poll());
        }

        System.out.println("\nIs Queue Empty? " + queue.isEmpty());
        System.out.println("Total Waiting Customers: " + queue.size());
    }
}