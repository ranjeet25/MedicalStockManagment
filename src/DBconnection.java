
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {

	public static void main(String[] args) {
		
		String dbname = "medicalstockmngmt";
		String dbusername = "root";
		String dbpassword ="ranjeet@sql";

		try {
			
			// Create DB connection 
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ dbname, dbusername, dbpassword );

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from medicine");

			while (rs.next()) {
				System.out.println(rs.getString("Suppliername"));
			}

		} catch (SQLException e) {
			System.out.println("Failed to connect to DB " + e.getMessage());
		}

	}

}
