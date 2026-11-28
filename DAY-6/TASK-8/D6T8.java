import java.sql.*;
import java.util.Scanner;

public class D6T8 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/library_management";
        String username = "root";
        String password = "mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books VALUES (?, ?, ?, ?, ?)"
            );

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Book Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();

            System.out.print("Enter Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Available Copies: ");
            int copies = sc.nextInt();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, author);
            ps.setString(4, category);
            ps.setInt(5, copies);

            ps.executeUpdate();
            System.out.println("Book added successfully!");

            Statement st = con.createStatement();

            System.out.println("\nAll Books:");
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("book_id") + " " +
                    rs.getString("book_name") + " " +
                    rs.getString("author") + " " +
                    rs.getString("category") + " " +
                    rs.getInt("available_copies")
                );
            }

            System.out.print("\nEnter Book ID to search: ");
            int searchId = sc.nextInt();

            PreparedStatement ps2 = con.prepareStatement(
                "SELECT * FROM books WHERE book_id = ?"
            );

            ps2.setInt(1, searchId);
            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                System.out.println("Book Name: " + rs2.getString("book_name"));
                System.out.println("Author: " + rs2.getString("author"));
                System.out.println("Copies: " + rs2.getInt("available_copies"));
            } else {
                System.out.println("Book not found!");
            }

            sc.nextLine();

            System.out.print("\nEnter Author Name to search: ");
            String searchAuthor = sc.nextLine();

            PreparedStatement ps3 = con.prepareStatement(
                "SELECT * FROM books WHERE author = ?"
            );

            ps3.setString(1, searchAuthor);
            ResultSet rs3 = ps3.executeQuery();

            boolean found = false;

            while (rs3.next()) {
                found = true;
                System.out.println(rs3.getString("book_name"));
            }

            if (!found) {
                System.out.println("No books found for this author!");
            }

            System.out.print("\nEnter Category: ");
            String searchCategory = sc.nextLine();

            PreparedStatement ps4 = con.prepareStatement(
                "SELECT * FROM books WHERE category = ?"
            );

            ps4.setString(1, searchCategory);
            ResultSet rs4 = ps4.executeQuery();

            found = false;

            while (rs4.next()) {
                found = true;
                System.out.println(rs4.getString("book_name"));
            }

            if (!found) {
                System.out.println("No books found in this category!");
            }

            System.out.print("\nEnter Book ID to update copies: ");
            int updateId = sc.nextInt();

            System.out.print("Enter New Available Copies: ");
            int newCopies = sc.nextInt();

            PreparedStatement ps5 = con.prepareStatement(
                "UPDATE books SET available_copies = ? WHERE book_id = ?"
            );

            ps5.setInt(1, newCopies);
            ps5.setInt(2, updateId);

            int rows = ps5.executeUpdate();

            if (rows > 0) {
                System.out.println("Book copies updated successfully!");
            } else {
                System.out.println("Book not found!");
            }

            System.out.println("\nBooks with Zero Available Copies:");

            ResultSet rs5 = st.executeQuery(
                "SELECT * FROM books WHERE available_copies = 0"
            );

            found = false;

            while (rs5.next()) {
                found = true;
                System.out.println(rs5.getString("book_name"));
            }

            if (!found) {
                System.out.println("No unavailable books found!");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}