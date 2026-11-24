interface RemoteControl {
    void turnOn();

    default void batteryStatus() {
        System.out.println("Remote battery is 100%");
    }
}

class TV implements RemoteControl {
    public void turnOn() {
        System.out.println("TV is turned ON");
    }
}

class AC implements RemoteControl {
    public void turnOn() {
        System.out.println("AC is turned ON");
    }
}

public class Main {
    public static void main(String[] args) {
        RemoteControl r1 = new TV();
        RemoteControl r2 = new AC();

        r1.turnOn();
        r1.batteryStatus();

        r2.turnOn();
        r2.batteryStatus();
    }
}