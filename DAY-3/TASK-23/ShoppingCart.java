import java.util.Scanner;

public class ShoppingCart {
    String[] products = {"Laptop", "Mobile", "Headphones", "Keyboard", "Mouse"};

    void selectProduct(int position) {
        try {
            System.out.println("Selected Product: " + products[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Product Position");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.print("Enter product position: ");
        int position = sc.nextInt();

        cart.selectProduct(position);

        sc.close();
    }
}