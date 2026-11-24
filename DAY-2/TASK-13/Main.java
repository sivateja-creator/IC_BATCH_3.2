interface Notification {
    void sendNotification();
}

class EmailNotification implements Notification {
    public void sendNotification() {
        System.out.println("Sending notification via Email");
    }
}

class SMSNotification implements Notification {
    public void sendNotification() {
        System.out.println("Sending notification via SMS");
    }
}

public class Main {
    public static void main(String[] args) {
        Notification n1 = new EmailNotification();
        Notification n2 = new SMSNotification();

        n1.sendNotification();
        n2.sendNotification();
    }
}