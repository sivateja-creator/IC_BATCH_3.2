interface Shape {
    void calculateArea(double value);
}

class Square implements Shape {
    public void calculateArea(double side) {
        System.out.println("Square Area: " + (side * side));
    }
}

class Circle implements Shape {
    public void calculateArea(double radius) {
        System.out.println("Circle Area: " + (3.14 * radius * radius));
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Square();
        Shape s2 = new Circle();

        s1.calculateArea(5.0);
        s2.calculateArea(5.0);
    }
}