class Manager {
}

class Developer {
}

public class EmployeeRoleManagement {

    public static void main(String[] args) {

        Object obj = new Developer();

        try {
            Manager m = (Manager) obj;
            System.out.println("Manager Object Created");
        } catch (ClassCastException e) {
            System.out.println("Invalid Employee Role Conversion");
        }

        Object obj2 = new Manager();

        try {
            Manager m2 = (Manager) obj2;
            System.out.println("Manager Object Created");
        } catch (ClassCastException e) {
            System.out.println("Invalid Employee Role Conversion");
        }
    }
}