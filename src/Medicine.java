import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Medicine  {
		
		private Connection connection;
		// Constructor for connection instance
		public Medicine(Connection connection) {
			this.connection = connection;
		}
	
	  	private String medicineID;
	  	private String medicineType;
	    private String medicineName;
	    private String medicineCompany;
	    private int medicineQuantity;
	    private String purchaseDate;
	    private double purchaseRate;
	    private String expiryDate;
		private String supplierName;
	    
	    // Method 02
	    public void inputMedicineDetails() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter Medicine ID: ");
	        this.medicineID = scanner.nextLine();
	        
	        System.out.println("Enter Medicine Type (Tablet/Syrup/Spray): ");
	        this.medicineType = scanner.nextLine();

	        System.out.println("Enter Medicine Name: ");
	        this.medicineName = scanner.nextLine();

	        System.out.println("Enter Medicine Company: ");
	        this.medicineCompany = scanner.nextLine();

	        System.out.println("Enter Medicine Quantity: ");
	        this.medicineQuantity = scanner.nextInt();

	        scanner.nextLine(); // Consume the newline character left by nextInt()

	        System.out.println("Enter Medicine Purchase Date (YYYY-MM-DD): ");
	        this.purchaseDate = scanner.nextLine();

	        System.out.println("Enter Medicine Purchase Rate: ");
	        this.purchaseRate = scanner.nextDouble();

	        scanner.nextLine(); // Consume the newline character left by nextDouble()

	        System.out.println("Enter Medicine Expiry Date (YYYY-MM-DD): ");
	        this.expiryDate = scanner.nextLine();

	        System.out.println("Enter Supplier Name: ");
	        this.supplierName = scanner.nextLine();

	        // Close the scanner to avoid resource leaks
	        scanner.close();
	    }
	
	
	// Method 02
	 public void insertMedicineDetails() {
	        try {
	        	 Statement statement = connection.createStatement();
	        	 
	        	 // SQL query to insert medicine details
	                String insertQuery = "INSERT INTO medicine" +
	                        "(medID, medicineType, medicineName, medicineCompany, Quantity, purchaseDate, purchaseRate, expiryDate, suppliername) " +
	                        "VALUES ('" + this.medicineID + "', '" + this.medicineType + "', '" + this.medicineName + "', '" +
	                        this.medicineCompany + "', " + this.medicineQuantity + ", '" + this.purchaseDate +
	                        "', " + this.purchaseRate + ", '" + this.expiryDate + "', '" + this.supplierName + "')";

	                // Execute the query
	                int rowEffected = statement.executeUpdate(insertQuery);
	                
	                if(rowEffected>0) {
	                	System.out.println("Medicine details inserted into the database sucessFully");
	                }else {
	                	System.out.println("Data Not Inserted :( ");
	                }
	                
	        } catch (SQLException e) {
	            System.out.println("Error executing query: " + e.getMessage());
	        }
	    }

}
