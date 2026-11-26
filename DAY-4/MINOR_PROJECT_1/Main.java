import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("       LIBRARY MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Register Student");
            System.out.println("5. Register Faculty");
            System.out.println("6. Display All Members");
            System.out.println("7. Search Member");
            System.out.println("8. Issue Book");
            System.out.println("9. Return Book");
            System.out.println("10. Display Issued Books");
            System.out.println("11. Generate Library Report");
            System.out.println("12. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String bookName = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Available Copies: ");
                    int copies = sc.nextInt();
                    sc.nextLine();

                    if (copies < 0) {
                        System.out.println("Copies Cannot Be Negative!");
                        break;
                    }

                    Book book = new Book(
                            bookId, bookName, author, category, copies);

                    library.addBook(book);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();
                    library.searchBook(bookId);
                    break;

                case 4:
                    System.out.print("Enter Student Name: ");
                    String studentName = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String studentContact = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String studentDepartment = sc.nextLine();

                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    library.registerStudent(studentName, studentContact,
                            studentDepartment, year);
                    break;

                case 5:
                    System.out.print("Enter Faculty Name: ");
                    String facultyName = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String facultyContact = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String facultyDepartment = sc.nextLine();

                    System.out.print("Enter Designation: ");
                    String designation = sc.nextLine();

                    library.registerFaculty(facultyName, facultyContact,
                            facultyDepartment, designation);
                    break;

                case 6:
                    library.displayMembers();
                    break;

                case 7:
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    library.searchMember(memberId);
                    break;

                case 8:
                    System.out.print("Enter Member ID: ");
                    memberId = sc.nextInt();

                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();

                    library.issueBook(bookId, memberId);
                    break;

                case 9:
                    System.out.print("Enter Member ID: ");
                    memberId = sc.nextInt();

                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();

                    library.returnBook(bookId, memberId);
                    break;

                case 10:
                    System.out.println("1. Display All Issue Records");
                    System.out.println("2. Display Active Issues Only");
                    System.out.print("Enter Choice: ");

                    int issueChoice = sc.nextInt();

                    if (issueChoice == 1) {
                        library.displayIssuedBooks(false);
                    } else if (issueChoice == 2) {
                        library.displayIssuedBooks(true);
                    } else {
                        System.out.println("Invalid Choice!");
                    }
                    break;

                case 11:
                    library.generateReport();
                    break;

                case 12:
                    System.out.println("Thank You For Using Library Management System!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 12);

        sc.close();
    }
}