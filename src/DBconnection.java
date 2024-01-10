
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {

	public static void main(String[] args) {
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root" ,"ranjeet@sql");
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from empinfo");
			
			while (rs.next()) {
				System.out.println(rs.getString("Name"));
			}
			
		} catch (SQLException e) {
			System.out.println("Failed to connect to DB " + e.getMessage());	
		}

	}

}
