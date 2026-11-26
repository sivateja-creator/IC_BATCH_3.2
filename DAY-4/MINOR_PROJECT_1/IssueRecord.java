public class IssueRecord {
    private int issueId;
    private int bookId;
    private int memberId;
    private String bookName;
    private boolean active;

    public IssueRecord(int issueId, int bookId, int memberId, String bookName) {
        this.issueId = issueId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.bookName = bookName;
        this.active = true;
    }

    public int getIssueId() {
        return issueId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void displayIssue() {
        System.out.println("Issue ID: " + issueId);
        System.out.println("Member ID: " + memberId);
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Status: " + (active ? "Active" : "Returned"));
        System.out.println("-----------------------------");
    }
}