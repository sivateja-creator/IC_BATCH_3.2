interface Printable {
    void printDocument();
}

interface Scannable {
    void scanDocument();
}

class SmartPrinter implements Printable, Scannable {
    public void printDocument() {
        System.out.println("Printing document...");
    }

    public void scanDocument() {
        System.out.println("Scanning document...");
    }
}

public class Main {
    public static void main(String[] args) {
        SmartPrinter sp = new SmartPrinter();

        sp.printDocument();
        sp.scanDocument();
    }
}