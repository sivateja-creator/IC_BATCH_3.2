import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> studentIds = new ArrayList<>();
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentMarks = new ArrayList<>();
        LinkedList<String> attendance = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n====================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Remove Student");
            System.out.println("6. Add Student Attendance");
            System.out.println("7. Display Attendance");
            System.out.println("8. Remove Attendance");
            System.out.println("9. Display Student Statistics");
            System.out.println("10. Sort Student Names");
            System.out.println("11. Exit");
            System.out.print("\nEnter Your Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (studentIds.contains(id)) {
                        System.out.println("Student ID Already Exists!");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Marks: ");
                    int marks = sc.nextInt();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid Marks! Enter 0 to 100.");
                        break;
                    }

                    studentIds.add(id);
                    studentNames.add(name);
                    studentMarks.add(marks);

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (studentNames.isEmpty()) {
                        System.out.println("No Student Records Found!");
                    } else {
                        System.out.println("\n--------- STUDENT RECORDS ---------");
                        System.out.printf("%-12s %-15s %s%n",
                                "Student ID", "Student Name", "Marks");

                        for (int i = 0; i < studentNames.size(); i++) {
                            System.out.printf("%-12d %-15s %d%n",
                                    studentIds.get(i),
                                    studentNames.get(i),
                                    studentMarks.get(i));
                        }

                        System.out.println("Total Students: " + studentNames.size());
                    }
                    break;

                case 3:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();

                    if (studentNames.contains(name)) {
                        int index = studentNames.indexOf(name);

                        System.out.println("Student Found!");
                        System.out.println("Student ID: " + studentIds.get(index));
                        System.out.println("Name: " + studentNames.get(index));
                        System.out.println("Marks: " + studentMarks.get(index));
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();

                    if (studentNames.contains(name)) {
                        int index = studentNames.indexOf(name);

                        System.out.print("Enter New Marks: ");
                        marks = sc.nextInt();

                        if (marks >= 0 && marks <= 100) {
                            studentMarks.set(index, marks);
                            System.out.println("Student Marks Updated Successfully!");
                        } else {
                            System.out.println("Invalid Marks! Enter 0 to 100.");
                        }
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();

                    if (studentNames.contains(name)) {
                        int index = studentNames.indexOf(name);

                        studentIds.remove(index);
                        studentNames.remove(index);
                        studentMarks.remove(index);

                        attendance.remove(name);

                        System.out.println("Student Removed Successfully!");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 6:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();

                    if (!studentNames.contains(name)) {
                        System.out.println("Student Not Found!");
                        break;
                    }

                    if (attendance.contains(name)) {
                        System.out.println("Student Already Marked Present!");
                        break;
                    }

                    System.out.println("1. Add at Beginning");
                    System.out.println("2. Add at End");
                    System.out.print("Enter Your Choice: ");
                    int position = sc.nextInt();

                    if (position == 1) {
                        attendance.addFirst(name);
                        System.out.println("Attendance Added at Beginning!");
                    } else if (position == 2) {
                        attendance.addLast(name);
                        System.out.println("Attendance Added at End!");
                    } else {
                        System.out.println("Invalid Choice!");
                    }
                    break;

                case 7:
                    if (attendance.isEmpty()) {
                        System.out.println("No Attendance Records Found!");
                    } else {
                        System.out.println("\n--------- ATTENDANCE LIST ---------");

                        for (String student : attendance) {
                            System.out.println(student);
                        }

                        System.out.println("Total Present Students: " + attendance.size());
                    }
                    break;

                case 8:
                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();

                    if (attendance.contains(name)) {
                        attendance.remove(name);
                        System.out.println("Attendance Removed Successfully!");
                    } else {
                        System.out.println("Student Not Found in Attendance!");
                    }
                    break;

                case 9:
                    if (studentMarks.isEmpty()) {
                        System.out.println("No Student Records Found!");
                        break;
                    }

                    int highest = Collections.max(studentMarks);
                    int lowest = Collections.min(studentMarks);
                    int total = 0;
                    int above75 = 0;

                    for (int mark : studentMarks) {
                        total += mark;

                        if (mark > 75) {
                            above75++;
                        }
                    }

                    double average = (double) total / studentMarks.size();

                    System.out.println("\n--------- STUDENT STATISTICS ---------");
                    System.out.println("Total Students: " + studentNames.size());
                    System.out.println("Highest Marks: " + highest);
                    System.out.println("Lowest Marks: " + lowest);
                    System.out.println("Average Marks: " + average);
                    System.out.println("Students Above 75: " + above75);
                    break;

                case 10:
                    if (studentNames.isEmpty()) {
                        System.out.println("No Student Records Found!");
                        break;
                    }

                    ArrayList<String> sortedNames = new ArrayList<>(studentNames);

                    Collections.sort(sortedNames);

                    System.out.println("\nNames in Alphabetical Order:");
                    System.out.println(sortedNames);

                    Collections.reverse(sortedNames);

                    System.out.println("Names in Reverse Order:");
                    System.out.println(sortedNames);
                    break;

                case 11:
                    studentNames.clear();
                    studentIds.clear();
                    studentMarks.clear();
                    attendance.clear();

                    System.out.println("Thank You! Application Closed.");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 11);

        sc.close();
    }
}