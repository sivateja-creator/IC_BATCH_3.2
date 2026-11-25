import java.util.Scanner;

public class TicketBooking {
    String passengerName = "Rahul";

    void displayCharacter(int position) {
        try {
            System.out.println("Character: " + passengerName.charAt(position));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid Character Position");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketBooking t = new TicketBooking();

        System.out.print("Enter character position: ");
        int position = sc.nextInt();

        t.displayCharacter(position);

        sc.close();
    }
}