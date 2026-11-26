import java.util.TreeMap;
import java.util.Map;
import java.util.Collections;

public class OnlineExaminationResultSystem {
    public static void main(String[] args) {

        TreeMap<Integer, Integer> results = new TreeMap<>();

        results.put(105, 85);
        results.put(102, 92);
        results.put(108, 76);
        results.put(101, 88);
        results.put(106, 95);
        results.put(104, 78);
        results.put(110, 90);
        results.put(103, 82);
        results.put(109, 98);
        results.put(107, 80);

        results.put(105, 91);

        System.out.println("All Student Results:");

        for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
            System.out.println("Roll Number: " + entry.getKey()
                    + " Marks: " + entry.getValue());
        }

        System.out.println("\nUpdated Marks of Roll Number 105: "
                + results.get(105));

        int highest = Collections.max(results.values());
        int lowest = Collections.min(results.values());

        System.out.println("\nHighest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);

        System.out.println("\nStudent with Highest Roll Number:");
        System.out.println(results.lastEntry());

        System.out.println("\nStudent with Lowest Roll Number:");
        System.out.println(results.firstEntry());

        System.out.println("\nResults from Roll Number 103 to 107:");

        for (Map.Entry<Integer, Integer> entry :
                results.subMap(103, true, 107, true).entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nResults in Reverse Roll Number Order:");

        for (Map.Entry<Integer, Integer> entry :
                results.descendingMap().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}