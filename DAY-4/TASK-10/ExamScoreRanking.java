import java.util.TreeSet;

public class ExamScoreRanking {
    public static void main(String[] args) {

        TreeSet<Integer> scores = new TreeSet<>();

        scores.add(85);
        scores.add(92);
        scores.add(78);
        scores.add(95);
        scores.add(88);
        scores.add(76);
        scores.add(90);
        scores.add(82);
        scores.add(98);
        scores.add(85);

        System.out.println("Exam Scores: " + scores);

        System.out.println("Highest Score: " + scores.last());
        System.out.println("Lowest Score: " + scores.first());

        System.out.println("Next Higher Score than 85: " + scores.higher(85));
        System.out.println("Next Lower Score than 85: " + scores.lower(85));

        System.out.println("Scores in Descending Order: " + scores.descendingSet());
    }
}