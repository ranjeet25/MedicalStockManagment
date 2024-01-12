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

	Scanner sc = new Scanner(System.in);
	
	
	
	// Search Medicine information by name Method

	public void searchMedicineWithName() {
		System.out.print("Enter Medine name : ");
		String medicineName = sc.nextLine();

		try {
			Statement statement = connection.createStatement();

			String searchQuery = "SELECT * FROM medicine WHERE medicineName LIKE '%" + medicineName + "%'";
			statement.executeQuery(searchQuery);

			ResultSet resultSet = statement.executeQuery(searchQuery);

			while (resultSet.next()) {
				System.out.println(resultSet.getString("Suppliername"));
			}

		} catch (SQLException e) {
			System.out.println("Error executing query: " + e.getMessage());
		}
	}
	
	
	
	

	// Method to Update Medicine Details

	public void updateMedicineDetails() {
	    System.out.print("Enter Medine ID to update Details : ");
	    int medicineID = sc.nextInt();
	    
	    // Consume the newline character left in the buffer
	    sc.nextLine();

	    System.out.println("select below fields to update :  ");
	    String[] medicineDetail = {"medicineName", "medicineCompany", "Quantity", "purchaseDate", "purchaseRate", "expiryDate", "suppliername"};

	    int number = 0;
	    for (String s : medicineDetail) {
	        System.out.println(++number + " " + s);
	    }

	    System.out.print("Enter the number corresponding to the field to update : ");
	    int selectedFieldNumber = sc.nextInt();

	    // Consume the newline character left in the buffer
	    sc.nextLine();

	    String medicineColumnToUpdate = medicineDetail[selectedFieldNumber - 1];

	    System.out.print("Enter New Value to be updated :  ");
	    String newMedicineDataToUpdate = sc.nextLine();

	    try {
	        Statement statement = connection.createStatement();
	        // Construct the UPDATE query with proper syntax
	        String updateQuery = "UPDATE medicine SET " + medicineColumnToUpdate + " = '" + newMedicineDataToUpdate +
	                              "' WHERE medID = " + medicineID;

	        int rowsAffected = statement.executeUpdate(updateQuery);

	        if (rowsAffected > 0) {
	            System.out.println("Data Updated Successfully");
	        } else {
	            System.out.println("Zero Rows Affected");
	        }

	    } catch (SQLException e) {
	        System.out.println("Error executing query: " + e.getMessage());
	    }
	}
	
	
	
	
	// Method to Display all available medicines
	
	public void viewAvailableMedicine() {

	    try {
	        Statement statement = connection.createStatement();

	        String searchQuery = "SELECT * FROM medicine WHERE Quantity > 0";
	        ResultSet resultSet = statement.executeQuery(searchQuery);

	        System.out.printf("%-6s%-15s%-20s%-20s%-10s%-15s%-15s%-15s%-20s\n",
	                "medID", "medicineType", "medicineName", "medicineCompany", "Quantity",
	                "purchaseDate", "purchaseRate", "expiryDate", "suppliername");

	        while (resultSet.next()) {
	            System.out.printf("%-6s%-15s%-20s%-20s%-10s%-15s%-15s%-15s%-20s\n",
	                    resultSet.getString("medID"),
	                    resultSet.getString("medicineType"),
	                    resultSet.getString("medicineName"),
	                    resultSet.getString("medicineCompany"),
	                    resultSet.getString("Quantity"),
	                    resultSet.getString("purchaseDate"),
	                    resultSet.getString("purchaseRate"),
	                    resultSet.getString("expiryDate"),
	                    resultSet.getString("suppliername"));
	        }

	    } catch (SQLException e) {
	        System.out.println("Error executing query: " + e.getMessage());
	    }
	}


}
