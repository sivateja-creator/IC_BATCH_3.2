class UserRegistration {

    void register(String name, int userId) {
        System.out.println("Registered user: " + name + " with ID: " + userId);
    }

    void register(int userId, String name) {
        System.out.println("Registered ID: " + userId + " for user: " + name);
    }
}

public class Main {
    public static void main(String[] args) {

        UserRegistration obj = new UserRegistration();

        obj.register("Siva", 101);
        obj.register(102, "Rahul");
    }
}