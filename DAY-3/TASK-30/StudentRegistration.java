import java.util.Scanner;

public class StudentRegistration {
    String studentName;
    int age;
    String marks;
    String[] subjects = {"Java", "Python", "SQL", "HTML"};

    void registerStudent(int position) {
        try {
            System.out.println("Student Name Length: " + studentName.length());

            int studentMarks = Integer.parseInt(marks);
            System.out.println("Student Marks: " + studentMarks);

            if (age <= 0) {
                throw new IllegalArgumentException();
            }

            System.out.println("Selected Subject: " + subjects[position]);
            System.out.println("Student Registration Completed");

        } catch (NullPointerException e) {
            System.out.println("Student name is not available");
        } catch (NumberFormatException e) {
            System.out.println("Please enter numeric marks only");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Subject Position");
        } catch (IllegalArgumentException e) {
            System.out.println("Age must be greater than zero");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRegistration s = new StudentRegistration();

        System.out.print("Enter student name: ");
        s.studentName = sc.nextLine();

        System.out.print("Enter age: ");
        s.age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter marks: ");
        s.marks = sc.nextLine();

        System.out.println("Subjects: 0.Java 1.Python 2.SQL 3.HTML");
        System.out.print("Enter subject position: ");
        int position = sc.nextInt();

        s.registerStudent(position);

        sc.close();
    }
}