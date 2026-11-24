class Student {
    private String name;
    private int rollNumber;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        s.setName("Rahul");
        s.setRollNumber(101);

        System.out.println("Name: " + s.getName());
        System.out.println("Roll Number: " + s.getRollNumber());
    }
}