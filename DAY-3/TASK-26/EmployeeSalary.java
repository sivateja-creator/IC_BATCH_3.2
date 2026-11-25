public class EmployeeSalary {

    void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater than zero");
        } else {
            System.out.println("Employee Salary: ₹" + salary);
        }
    }

    public static void main(String[] args) {
        EmployeeSalary e = new EmployeeSalary();

        try {
            e.setSalary(25000);
            e.setSalary(50000);
            e.setSalary(0);
            e.setSalary(-1000);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}