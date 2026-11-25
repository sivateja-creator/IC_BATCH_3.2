import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentMarks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter marks for three subjects: ");

            int mark1 = sc.nextInt();
            int mark2 = sc.nextInt();
            int mark3 = sc.nextInt();

            int total = mark1 + mark2 + mark3;
            double average = total / 3.0;

            System.out.println("Total Marks: " + total);
            System.out.println("Average Marks: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Please enter numeric marks only");
        }

        sc.close();
    }
}