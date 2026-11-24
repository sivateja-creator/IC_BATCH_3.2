abstract class Appliance {
    void plugIn() {
        System.out.println("Appliance plugged into power");
    }

    abstract void operate();
}

class Fan extends Appliance {
    void operate() {
        System.out.println("Fan is spinning at high speed");
    }
}

class WashingMachine extends Appliance {
    void operate() {
        System.out.println("Washing machine is washing clothes");
    }
}

public class Main {
    public static void main(String[] args) {
        Fan f = new Fan();
        WashingMachine w = new WashingMachine();

        f.plugIn();
        f.operate();

        w.plugIn();
        w.operate();
    }
}