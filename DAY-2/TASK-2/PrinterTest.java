class Printer {

    void print(String text) {
        System.out.println("Text: " + text);
    }

    void print(int number) {
        System.out.println("Integer: " + number);
    }

    void print(double decimal) {
        System.out.println("Decimal: " + decimal);
    }
}

public class PrinterTest {
    public static void main(String[] args) {

        Printer obj = new Printer();

        obj.print("Hello Java");
        obj.print(100);
        obj.print(25.5);
    }
}