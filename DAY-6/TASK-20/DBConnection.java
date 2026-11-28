import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_management";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql@123";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver Not Found", e);
        }

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement()) {
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS employee_management");
        }

        Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        try (Statement st = con.createStatement()) {
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS employees (" +
                "employee_id INT PRIMARY KEY, " +
                "employee_name VARCHAR(100), " +
                "department VARCHAR(50), " +
                "salary DOUBLE)"
            );
        }

        return con;
    }
}