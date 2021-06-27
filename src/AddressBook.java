import java.util.*;
import java.io.*;

public class AddressBook {
	// Initializing an ArrayList to store the contact details
	ArrayList<Person> records = new ArrayList<Person>();

	public void addPerson(String firstName, String lastName, String address, String city, String state, int zip,
			String phoneNumber) {
		Person personObj = new Person(firstName, lastName, phoneNumber, address, city, state, zip);
		records.add(personObj);
	}

	public void displayOptions() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		int flag = 0;
		while (flag == 0) {
			System.out.println("Select from the following options:");
			System.out.println("1 for add new person details in the address book");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				scanner.nextLine();
				System.out.println("Enter first name: ");
				String var1 = scanner.nextLine();
				System.out.println("Enter last name: ");
				String var2 = scanner.nextLine();
				System.out.println("Enter address: ");
				String var3 = scanner.nextLine();
				System.out.println("Enter city: ");
				String var4 = scanner.nextLine();
				System.out.println("Enter state: ");
				String var5 = scanner.nextLine();
				System.out.println("Enter zip: ");
				int var6 = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter phone no: ");
				String var7 = scanner.nextLine();
				// Passing the values to the addPerson class
				addPerson(var1, var2, var3, var4, var5, var6, var7);
				System.out.println();
				System.out.println("Information added successfully.\n");
				// Printing the list for confirmation
				System.out.println(records);
				System.out.println();
				break;

			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book");
		AddressBook object = new AddressBook();
		object.displayOptions();
	}
}
