class Employee {
    String name;
    double baseSalary;

    void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + baseSalary);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    void writeCode() {
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println("Developer is writing code");
    }
}

class Tester extends Employee {
    String testingTool;

    void runTests() {
        System.out.println("Testing Tool: " + testingTool);
        System.out.println("Tester is running tests");
    }
}

public class Main {
    public static void main(String[] args) {
        Developer d = new Developer();

        d.name = "Rahul";
        d.baseSalary = 40000;
        d.programmingLanguage = "Java";

        d.displayBasicInfo();
        d.writeCode();

        Tester t = new Tester();

        t.name = "Priya";
        t.baseSalary = 35000;
        t.testingTool = "Selenium";

        t.displayBasicInfo();
        t.runTests();
    }
}