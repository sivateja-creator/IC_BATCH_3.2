class Employee {

    double baseSalary;

    double calculateSalary() {
        return baseSalary;
    }
}

class SalesEmployee extends Employee {

    double bonus;

    double calculateSalary() {
        return super.calculateSalary() + bonus;
    }
}

public class Main {
    public static void main(String[] args) {

        SalesEmployee s = new SalesEmployee();

        s.baseSalary = 30000;
        s.bonus = 5000;

        System.out.println("Total Salary: " + s.calculateSalary());
    }
}