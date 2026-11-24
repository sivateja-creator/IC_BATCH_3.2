class Vehicle {
    String brand;

    void honk() {
        System.out.println("Beep! Beep!");
    }
}

class Car extends Vehicle {
    String modelName;

    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + modelName);
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();

        c.brand = "Toyota";
        c.modelName = "Fortuner";

        c.honk();
        c.displayDetails();
    }
}