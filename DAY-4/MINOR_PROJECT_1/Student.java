public class Student extends LibraryMember {
    private String department;
    private int year;

    public Student(int memberId, String memberName, String contactNumber,
                   String department, int year) {
        super(memberId, memberName, contactNumber);
        this.department = department;
        this.year = year;
    }

    @Override
    public void displayMemberDetails() {
        System.out.println("\nStudent Details");
        super.displayMemberDetails();
        System.out.println("Department: " + department);
        System.out.println("Year: " + year);
        System.out.println("-----------------------------");
    }
}