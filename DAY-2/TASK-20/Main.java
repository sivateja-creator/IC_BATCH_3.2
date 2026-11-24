class Employee {
    int id;
    String name;
    String department;

    Employee(int id, String name) {
        this(id, name, "General");
    }

    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    void displayEmployee() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Rahul");
        Employee e2 = new Employee(102, "Priya", "IT");

        e1.displayEmployee();
        e2.displayEmployee();
    }
}