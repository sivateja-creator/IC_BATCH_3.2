abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void showName() {
        System.out.println("Employee: " + name);
    }

    abstract void calculateSalary();
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    void calculateSalary() {
        System.out.println("Monthly Salary: ₹" + monthlySalary);
    }
}

public class Main {
    public static void main(String[] args) {
        FullTimeEmployee e = new FullTimeEmployee("Rahul", 30000);

        e.showName();
        e.calculateSalary();
    }
}