import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Library extends LibraryOperations {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<LibraryMember> members = new ArrayList<>();

    private HashMap<Integer, Book> bookMap = new HashMap<>();

    private LinkedHashMap<Integer, IssueRecord> issueRecords =
            new LinkedHashMap<>();

    private HashSet<Integer> issuedBookIds = new HashSet<>();

    private int nextMemberId = 1001;
    private int nextIssueId = 1;

    @Override
    public void addBook(Book book) {

        if (bookMap.containsKey(book.getBookId())) {
            System.out.println("Book ID Already Exists!");
            return;
        }

        books.add(book);
        bookMap.put(book.getBookId(), book);

        System.out.println("Book Added Successfully!");
    }

    @Override
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available!");
            return;
        }

        System.out.println("\nAll Library Books");

        for (Book book : books) {
            book.displayBook();
        }

        System.out.println("Total Books: " + books.size());
    }

    public void searchBook(int bookId) {

        Book book = bookMap.get(bookId);

        if (book != null) {
            System.out.println("\nBook Found!");
            book.displayBook();
        } else {
            System.out.println("Book Not Found!");
        }
    }

    public void registerStudent(String name, String contact,
                                String department, int year) {

        Student student = new Student(
                nextMemberId++, name, contact, department, year);

        members.add(student);

        System.out.println("Student Registered Successfully!");
        System.out.println("Student Member ID: " + student.getMemberId());
    }

    public void registerFaculty(String name, String contact,
                                String department, String designation) {

        Faculty faculty = new Faculty(
                nextMemberId++, name, contact, department, designation);

        members.add(faculty);

        System.out.println("Faculty Registered Successfully!");
        System.out.println("Faculty Member ID: " + faculty.getMemberId());
    }

    public void displayMembers() {

        if (members.isEmpty()) {
            System.out.println("No Members Registered!");
            return;
        }

        System.out.println("\nRegistered Library Members");

        for (LibraryMember member : members) {
            member.displayMemberDetails();
        }

        System.out.println("Total Members: " + members.size());
    }

    public void searchMember(int memberId) {

        for (LibraryMember member : members) {

            if (member.getMemberId() == memberId) {
                System.out.println("Member Found!");
                member.displayMemberDetails();
                return;
            }
        }

        System.out.println("Member Not Found!");
    }

    private LibraryMember findMember(int memberId) {

        for (LibraryMember member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }

        return null;
    }

    @Override
    public void issueBook(int bookId, int memberId) {

        LibraryMember member = findMember(memberId);
        Book book = bookMap.get(bookId);

        if (member == null) {
            System.out.println("Member Does Not Exist!");
            return;
        }

        if (book == null) {
            System.out.println("Book Does Not Exist!");
            return;
        }

        if (book.getAvailableCopies() <= 0) {
            System.out.println("Book Is Not Available!");
            return;
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        IssueRecord record = new IssueRecord(
                nextIssueId++, bookId, memberId, book.getBookName());

        issueRecords.put(record.getIssueId(), record);
        issuedBookIds.add(bookId);

        System.out.println("\nBook Issued Successfully!");
        System.out.println("Member: " + member.getMemberName());
        System.out.println("Book: " + book.getBookName());
        System.out.println("Available Copies: " + book.getAvailableCopies());
    }

    @Override
    public void returnBook(int bookId, int memberId) {

        for (IssueRecord record : issueRecords.values()) {

            if (record.getBookId() == bookId
                    && record.getMemberId() == memberId
                    && record.isActive()) {

                Book book = bookMap.get(bookId);

                if (book != null) {
                    book.setAvailableCopies(book.getAvailableCopies() + 1);
                }

                record.setActive(false);

                boolean stillIssued = false;

                for (IssueRecord r : issueRecords.values()) {
                    if (r.getBookId() == bookId && r.isActive()) {
                        stillIssued = true;
                        break;
                    }
                }

                if (!stillIssued) {
                    issuedBookIds.remove(bookId);
                }

                System.out.println("Book Returned Successfully!");
                return;
            }
        }

        System.out.println("No Active Issue Record Found!");
    }

    public void displayIssuedBooks(boolean activeOnly) {

        if (issueRecords.isEmpty()) {
            System.out.println("No Issue Records Available!");
            return;
        }

        System.out.println("\nBook Issue Records");

        boolean found = false;

        for (IssueRecord record : issueRecords.values()) {

            if (!activeOnly || record.isActive()) {
                record.displayIssue();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Active Issue Records!");
        }
    }

    public void generateReport() {

        int totalCopies = 0;
        int activeIssues = 0;
        int unavailableBooks = 0;

        for (Book book : books) {

            totalCopies += book.getAvailableCopies();

            if (book.getAvailableCopies() == 0) {
                unavailableBooks++;
            }
        }

        for (IssueRecord record : issueRecords.values()) {

            if (record.isActive()) {
                activeIssues++;
            }
        }

        System.out.println("\n========== LIBRARY REPORT ==========");
        System.out.println("Total Books Registered: " + books.size());
        System.out.println("Total Registered Members: " + members.size());
        System.out.println("Total Active Issues: " + activeIssues);
        System.out.println("Total Available Copies: " + totalCopies);
        System.out.println("Books Currently Unavailable: " + unavailableBooks);
        System.out.println("Unique Currently Issued Book IDs: "
                + issuedBookIds.size());
        System.out.println("====================================");
    }
}