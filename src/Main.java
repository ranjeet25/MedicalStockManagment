import java.util.*;

public class Main {

	public static void main(String[] args) {

		int choice;

		do {
			displayMenu();
			DBconnection createConnection = new DBconnection();
			choice = getUserChoice();
			
			switch (choice) {
			case 1:
				Medicine med1 = new Medicine(DBconnection.connection);
				med1.inputMedicineDetails();
				med1.insertMedicineDetails();
				
				break;
			case 2:
				MedicineManager med2 = new MedicineManager(DBconnection.connection);
				med2.searchMedicineWithName();
				break;
			case 3:
				MedicineManager med3 = new MedicineManager(DBconnection.connection);
				med3.updateMedicineDetails();
				break;
			case 4:
				MedicineManager med4 = new MedicineManager(DBconnection.connection);
				med4.viewAvailableMedicine();
				break;
			case 5:
				System.out.println(" ******* Comming Soon...... ******* ");
				break;
			case 6:
				System.out.println("Exiting the program. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 6);

	}

	// Display Menu method
	public static void displayMenu() {

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
