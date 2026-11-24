class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    void showResult() {
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Rahul", 85.5);
        Student s2 = new Student("Priya", 92.0);

        s1.showResult();
        s2.showResult();
    }
}