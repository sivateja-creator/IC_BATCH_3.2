class StudentName {
    String name = "Saran Velmurugan";

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Total Characters: " + name.length());
        System.out.println("First Character: " + name.charAt(0));
        System.out.println("Last Character: " + name.charAt(name.length() - 1));
        System.out.println("Fifth Character: " + name.charAt(4));
    }
}

public class Main {
    public static void main(String[] args) {
        StudentName s = new StudentName();
        s.displayDetails();
    }
}