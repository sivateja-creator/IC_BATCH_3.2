public class StudentProfile {
    String studentName = null;

    void displayName() {
        try {
            System.out.println("Name Length: " + studentName.length());
        } catch (NullPointerException e) {
            System.out.println("Student name is not available");
        }
    }

    public static void main(String[] args) {
        StudentProfile s = new StudentProfile();

        s.displayName();

        s.studentName = "Saran";
        s.displayName();
    }
}