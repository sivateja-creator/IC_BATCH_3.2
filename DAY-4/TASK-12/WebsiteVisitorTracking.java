import java.util.LinkedHashSet;

public class WebsiteVisitorTracking {
    public static void main(String[] args) {

        LinkedHashSet<Integer> visitors = new LinkedHashSet<>();

        visitors.add(101);
        visitors.add(102);
        visitors.add(103);
        visitors.add(104);
        visitors.add(105);
        visitors.add(106);
        visitors.add(107);
        visitors.add(108);
        visitors.add(109);
        visitors.add(110);

        System.out.println("Visitor IDs: " + visitors);

        visitors.add(111);
        System.out.println("After Adding New Visitor: " + visitors);

        visitors.add(103);
        System.out.println("After Adding Duplicate Visitor: " + visitors);

        visitors.remove(105);
        System.out.println("After Removing Visitor: " + visitors);

        System.out.println("Has Visitor 103 Visited? " + visitors.contains(103));

        System.out.println("Total Unique Visitors: " + visitors.size());

        System.out.println("Visitors in Arrival Order:");

        for (int id : visitors) {
            System.out.println(id);
        }
    }
}