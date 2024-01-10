
import java.util.*;

public class Main {

	public static void main(String[] args) {

		int choice;

		do {
			displayMenu();
			choice = getUserChoice();
			switch (choice) {
			case 1:
				System.out.println("Add new Medicine Details");
				break;
			case 2:
				System.out.println("Search Medicine Details");
				break;
			case 3:
				System.out.println("Update Medicine Details");
				break;
			case 4:
				System.out.println("View all Medicine Details");
				break;
			case 5:
				System.out.println("Generate Reports");
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

		System.out.println("****** Medical Stock Management System ******");

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
