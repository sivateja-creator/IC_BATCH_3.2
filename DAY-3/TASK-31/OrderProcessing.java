import java.util.Scanner;

public class OrderProcessing {
    String productName = "Laptop";
    String quantity = "2";
    double[] productPrices = {45000, 55000, 65000};

    void processOrder(int position) {
        try {
            int qty = Integer.parseInt(quantity);

            double productPrice = productPrices[position];
            double totalPrice = qty * productPrice;

            System.out.println("Product Name: " + productName);
            System.out.println("Quantity: " + qty);
            System.out.println("Product Price: ₹" + productPrice);
            System.out.println("Total Price: ₹" + totalPrice);

        } catch (NumberFormatException e) {
            System.out.println("Invalid Quantity Format");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Product Position");
        } finally {
            System.out.println("Order Processing Completed");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderProcessing o = new OrderProcessing();

        System.out.print("Enter product position: ");
        int position = sc.nextInt();

        o.processOrder(position);

        sc.close();
    }
}