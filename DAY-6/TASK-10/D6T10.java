import java.sql.*;
import java.util.Scanner;

public class D6T10 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hospital_management";
        String username = "root";
        String password = "<YOUR_PASSWORD>";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO patients VALUES (?, ?, ?, ?, ?)"
            );

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();

            System.out.print("Enter Doctor Name: ");
            String doctor = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, disease);
            ps.setString(5, doctor);

            ps.executeUpdate();
            System.out.println("Patient registered successfully!");

            System.out.println("\nAll Registered Patients:");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patients");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("patient_id") + " " +
                    rs.getString("patient_name") + " " +
                    rs.getInt("age") + " " +
                    rs.getString("disease") + " " +
                    rs.getString("doctor_name")
                );
            }

            System.out.print("\nEnter Patient ID to search: ");
            int searchId = sc.nextInt();

            PreparedStatement ps2 = con.prepareStatement(
                "SELECT * FROM patients WHERE patient_id = ?"
            );

            ps2.setInt(1, searchId);
            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                System.out.println("Patient Name: " + rs2.getString("patient_name"));
                System.out.println("Disease: " + rs2.getString("disease"));
                System.out.println("Doctor: " + rs2.getString("doctor_name"));
            } else {
                System.out.println("Patient not found!");
            }

            sc.nextLine();

            System.out.print("\nEnter Disease Name: ");
            String searchDisease = sc.nextLine();

            PreparedStatement ps3 = con.prepareStatement(
                "SELECT * FROM patients WHERE disease = ?"
            );

            ps3.setString(1, searchDisease);
            ResultSet rs3 = ps3.executeQuery();

            boolean found = false;

            while (rs3.next()) {
                found = true;
                System.out.println(rs3.getString("patient_name"));
            }

            if (!found) {
                System.out.println("No patients found with this disease!");
            }

            System.out.print("\nEnter Patient ID to update doctor: ");
            int updateId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Doctor Name: ");
            String newDoctor = sc.nextLine();

            PreparedStatement ps4 = con.prepareStatement(
                "UPDATE patients SET doctor_name = ? WHERE patient_id = ?"
            );

            ps4.setString(1, newDoctor);
            ps4.setInt(2, updateId);

            int updated = ps4.executeUpdate();

            if (updated > 0) {
                System.out.println("Doctor updated successfully!");
            } else {
                System.out.println("Patient not found!");
            }

            System.out.print("\nEnter Patient ID to delete: ");
            int deleteId = sc.nextInt();

            PreparedStatement ps5 = con.prepareStatement(
                "DELETE FROM patients WHERE patient_id = ?"
            );

            ps5.setInt(1, deleteId);

            int deleted = ps5.executeUpdate();

            if (deleted > 0) {
                System.out.println("Patient record deleted successfully!");
            } else {
                System.out.println("Patient not found!");
            }

            sc.nextLine();

            System.out.print("\nEnter Doctor Name to search: ");
            String searchDoctor = sc.nextLine();

            PreparedStatement ps6 = con.prepareStatement(
                "SELECT * FROM patients WHERE doctor_name = ?"
            );

            ps6.setString(1, searchDoctor);
            ResultSet rs6 = ps6.executeQuery();

            found = false;

            while (rs6.next()) {
                found = true;
                System.out.println(
                    rs6.getInt("patient_id") + " " +
                    rs6.getString("patient_name") + " " +
                    rs6.getString("disease")
                );
            }

            if (!found) {
                System.out.println("No patients assigned to this doctor!");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}