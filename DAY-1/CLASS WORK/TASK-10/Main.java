class Shape {
    String color;

    void displayColor() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    double radius;

    double calculateArea() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    double calculateArea() {
        return length * width;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle();

        c.color = "Red";
        c.radius = 5;

        Rectangle r = new Rectangle();

        r.color = "Blue";
        r.length = 10;
        r.width = 4;

        c.displayColor();
        System.out.println("Circle Area: " + c.calculateArea());

        r.displayColor();
        System.out.println("Rectangle Area: " + r.calculateArea());
    }
}