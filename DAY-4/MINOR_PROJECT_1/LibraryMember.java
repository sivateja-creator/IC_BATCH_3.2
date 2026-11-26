public class LibraryMember {
    private int memberId;
    private String memberName;
    private String contactNumber;

    public LibraryMember(int memberId, String memberName, String contactNumber) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.contactNumber = contactNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void displayMemberDetails() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Member Name: " + memberName);
        System.out.println("Contact Number: " + contactNumber);
    }
}