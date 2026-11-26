public abstract class LibraryOperations {

    abstract void addBook(Book book);

    abstract void displayBooks();

    abstract void issueBook(int bookId, int memberId);

    abstract void returnBook(int bookId, int memberId);
}