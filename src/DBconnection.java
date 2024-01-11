import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	// Instance variables for connection
    public static Connection connection;

    public DBconnection() {
        final String dburl = "jdbc:mysql://localhost:3306/medicalstockmngmt";
        final String dbusername = "root";
        final String dbpassword = "ranjeet@sql";

        try {
            // Create DB connection
            connection = DriverManager.getConnection(dburl, dbusername, dbpassword);
   
        } catch (SQLException e) {
            System.out.println("Failed to connect to DB " + e.getMessage());
        }
    }


    public static void main(String[] args) {
    	
    }
}
