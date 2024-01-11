import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class MedicineManager {
	
	private Connection connection;
	// Constructor for connection instance
	public MedicineManager(Connection connection) {
		this.connection = connection;
	}

	
	public void searchMedicineWithName() {
		System.out.print("Enter Medine name : ");
		Scanner sc = new Scanner(System.in);
		String medicineName = sc.nextLine();
		
		try {
			Statement statement = connection.createStatement();
			
			String searchQuery = "SELECT * FROM medicine WHERE medicineName LIKE '%" + medicineName + "%'"; 
			statement.executeQuery(searchQuery);
			
			ResultSet resultSet = statement.executeQuery(searchQuery);
			
			while (resultSet.next()) {
				 System.out.println(resultSet.getString("Suppliername"));
			}
			
		}catch (SQLException e) {
			System.out.println("Error executing query: " + e.getMessage());
		}
	}
	
	public void updateMedicineDetails() {
		
	}

}
