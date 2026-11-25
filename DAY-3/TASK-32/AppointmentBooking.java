import java.util.Scanner;

public class AppointmentBooking {
    String patientName = "Rahul";
    int age = 25;
    String appointmentTime = "10:30 AM";
    String[] availableSlots = {"09:00 AM", "10:30 AM", "12:00 PM"};

    void bookAppointment(int position) {
        try {
            if (patientName == null) {
                throw new NullPointerException();
            }

            System.out.println("Patient Name: " + patientName);
            System.out.println("Name Length: " + patientName.length());

            if (age <= 0) {
                throw new IllegalArgumentException();
            }

            System.out.println("Age: " + age);

            String selectedSlot = availableSlots[position];

            System.out.println("Appointment Time: " + selectedSlot);
            System.out.println("Appointment Booked Successfully");

        } catch (NullPointerException e) {
            System.out.println("Patient information is not available");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Patient Age");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Appointment Slot");
        } finally {
            System.out.println("Appointment Booking Process Completed");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentBooking a = new AppointmentBooking();

        System.out.print("Enter appointment slot position: ");
        int position = sc.nextInt();

        a.bookAppointment(position);

        sc.close();
    }
}