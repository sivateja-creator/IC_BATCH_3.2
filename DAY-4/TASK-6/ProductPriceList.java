import java.util.ArrayList;
import java.util.Collections;

public class ProductPriceList {
    public static void main(String[] args) {

        ArrayList<Integer> prices = new ArrayList<>();

        prices.add(500);
        prices.add(1200);
        prices.add(800);
        prices.add(2500);
        prices.add(1500);
        prices.add(3000);
        prices.add(700);
        prices.add(2000);
        prices.add(1800);
        prices.add(1000);

        System.out.println("All Product Prices: " + prices);

        prices.set(2, 900);
        System.out.println("After Updating Price: " + prices);

        System.out.println("Highest Price: " + Collections.max(prices));
        System.out.println("Lowest Price: " + Collections.min(prices));

        int total = 0;

        for (int price : prices) {
            total += price;
        }

        double average = (double) total / prices.size();

        System.out.println("Average Price: " + average);

        Collections.sort(prices);
        System.out.println("Prices in Ascending Order: " + prices);

        System.out.println("Prices Between 1000 and 2000:");

        for (int price : prices) {
            if (price >= 1000 && price <= 2000) {
                System.out.println(price);
            }
        }
    }
}