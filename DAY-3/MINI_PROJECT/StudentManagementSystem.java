import java.util.Scanner;

class Student {
    private int studentId;
    private String studentName;
    private String department;
    private int mark1, mark2, mark3;

    Student(int id, String name, String dept) {
        studentId = id;
        studentName = name;
        department = dept;
    }

    void enterMarks(int m1, int m2, int m3) {
        mark1 = m1;
        mark2 = m2;
        mark3 = m3;
    }

    int calculateTotal() {
        return mark1 + mark2 + mark3;
    }

    double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    String calculateGrade() {
        double average = calculateAverage();

        if (average >= 90)
            return "A+";
        else if (average >= 80)
            return "A";
        else if (average >= 70)
            return "B";
        else if (average >= 60)
            return "C";
        else if (average >= 50)
            return "D";
        else
            return "Fail";
    }

    String calculateResult() {
        if (mark1 >= 35 && mark2 >= 35 && mark3 >= 35)
            return "PASS";
        else
            return "FAIL";
    }

    void displayStudent() {
        System.out.println("\n===== STUDENT REPORT =====");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + studentName);
        System.out.println("Department : " + department);
        System.out.println("Mark 1     : " + mark1);
        System.out.println("Mark 2     : " + mark2);
        System.out.println("Mark 3     : " + mark3);
        System.out.println("Total Marks: " + calculateTotal());
        System.out.println("Average    : " + calculateAverage());
        System.out.println("Grade      : " + calculateGrade());
        System.out.println("Result     : " + calculateResult());
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = null;
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Enter Marks");
            System.out.println("4. Calculate Total");
            System.out.println("5. Calculate Average");
            System.out.println("6. Calculate Grade");
            System.out.println("7. Pass/Fail");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    student = new Student(id, name, dept);

                    System.out.println("Student Added Successfully");
                    break;

                case 2:
                    if (student != null)
                        student.displayStudent();
                    else
                        System.out.println("Please Add Student First");
                    break;

                case 3:
                    if (student != null) {
                        System.out.print("Enter Subject 1 Marks: ");
                        int m1 = sc.nextInt();

                        System.out.print("Enter Subject 2 Marks: ");
                        int m2 = sc.nextInt();

                        System.out.print("Enter Subject 3 Marks: ");
                        int m3 = sc.nextInt();

                        student.enterMarks(m1, m2, m3);

                        System.out.println("Marks Added Successfully");
                    } else {
                        System.out.println("Please Add Student First");
                    }
                    break;

                case 4:
                    if (student != null)
                        System.out.println("Total Marks: " + student.calculateTotal());
                    else
                        System.out.println("Please Add Student First");
                    break;

                case 5:
                    if (student != null)
                        System.out.println("Average Marks: " + student.calculateAverage());
                    else
                        System.out.println("Please Add Student First");
                    break;

                case 6:
                    if (student != null)
                        System.out.println("Grade: " + student.calculateGrade());
                    else
                        System.out.println("Please Add Student First");
                    break;

                case 7:
                    if (student != null)
                        System.out.println("Result: " + student.calculateResult());
                    else
                        System.out.println("Please Add Student First");
                    break;

                case 8:
                    System.out.println("Thank You! Application Closed.");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 8);

        sc.close();
    }
}