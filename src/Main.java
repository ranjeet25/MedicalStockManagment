import java.util.*;
import org.apache.logging.log4j.*;

public class Main {
	
	public static Logger log = LogManager.getLogger(Main.class.getName());
	
	public static void main(String[] args) {

		int choice;
		
		do {
			displayMenu(); 
			DBconnection createConnection = new DBconnection();
			choice = getUserChoice();
			
			switch (choice) {
			case 1:
				Medicine medicineDetail = new Medicine(DBconnection.connection);
				medicineDetail.inputMedicineDetails();
				medicineDetail.insertMedicineDetails();
				
				break;
			case 2:
				MedicineManager searchMedicine = new MedicineManager(DBconnection.connection, log);
				searchMedicine.searchMedicineWithName();
				break;
			case 3:
				MedicineManager updateMedicine = new MedicineManager(DBconnection.connection, log);
				updateMedicine.updateMedicineDetails();
				break;
			case 4:
				MedicineManager viewAllMedicine = new MedicineManager(DBconnection.connection, log);
				viewAllMedicine.viewAvailableMedicine();
				break;
			case 5:
				System.out.println(" ******* Comming Soon...... ******* ");
				break;
			case 6:
				log.info("Exiting the program. Goodbye!");
				System.out.println("Exiting the program. Goodbye!");
				break;
			default:
				log.warn("Invalid choice entered: {}", choice);
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 6);

	}

	// Display Menu method
	public static void displayMenu() {
		
		System.out.println();
		System.out.println("****** Medical Stock Management System ******\n");

		System.out.println("1. Add new Medicine Details");
		System.out.println("2. Search Medicine Details");
		System.out.println("3. Update Medicine Details");
		System.out.println("4. View all Medicine Details");
		System.out.println("5. Generate Reports");
		System.out.println("6. Exit");
	}

	// Get user choice method
	public static int getUserChoice() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		
		return choice;

	}
	
	

}
