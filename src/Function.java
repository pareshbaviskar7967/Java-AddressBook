import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Function {
	ArrayList<Person> records = new ArrayList<Person>();
	// HashMap<String, ArrayList<com.work.Person>> addressBooks = new
	// HashMap<String, ArrayList<com.work.Person>>();

	// PersonOprations
	public void addPerson(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber) {
		Person personObj = new Person(firstName, lastName, phoneNumber, address, city, state, zip);
		int result = personObj.findPhoneNo(records, phoneNumber);
		if (result != -1) {
			System.out.println("The address book already has details with " + phoneNumber + " this phone number.");
		} else {
			records.add(personObj);
			System.out.println();
			System.out.println("Information added successfully.\n");
		}
	}

	public static int findIndex(ArrayList<Person> records, String fname, String lname) {
		for (int i = 0; i < records.size(); i++) {
			String f = records.get(i).getFname();
			String l = records.get(i).getLname();
			if (f.equals(fname) && l.equals(lname)) {
				return i;
			}
		}
		return -1;
	}

	public void editPerson(String value, String option, int index) {
		Person personObj = records.get(index);
		if (option == "a") {
			personObj.setAddress(value);
		} else if (option == "c") {
			personObj.setCity(value);
		} else if (option == "s") {
			personObj.setState(value);
		} else if (option == "p") {
			personObj.setPhoneNumber(value);
		} else if (option == "z") {
			personObj.setPin(value);
		}
		records.set(index, personObj);
	}

	public void deletePerson(String fname, String lname) {
		int size = records.size();
		for (int i = 0; i < size; i++) {
			String f = records.get(i).getFname();
			String l = records.get(i).getLname();
			if (f.equals(fname) && l.equals(lname)) {
				records.remove(i);
				break;
			}
		}
	}

	public void displayAll(ArrayList<Person> arr) {
		boolean isEmpty = arr.isEmpty();
		if (isEmpty == true) {
			System.out.println("No record(s) found \n");
		} else {
			System.out.println(arr);
			System.out.println();
		}
	}

	public static void searchByCity(List<Person> person) {
		System.out.println("Enter the city name to search contacts: ");
		Scanner scanner = new Scanner(System.in);
		String city = scanner.nextLine();
		person.stream().filter(map -> map.getCity().equals(city)).forEach(persons -> System.out.println(persons));
	}

	public static void searchByState(List<Person> person) {
		System.out.println("Enter the state name to search contacts: ");
		Scanner scanner = new Scanner(System.in);
		String state = scanner.nextLine();
		person.stream().filter(map -> map.getState().equals(state)).forEach(persons -> System.out.println(persons));
	}

	public static void viewByCity(List<Person> person) {
		System.out.println("Enter the city name to view contacts: ");
		Scanner scanner = new Scanner(System.in);
		String city = scanner.nextLine();
		person.stream().filter(map -> map.getCity().contains(city))
				.forEach(persons -> System.out.println("Name: " + persons.getFname() + persons.getLname()));
	}

	public static void viewByState(List<Person> person) {
		System.out.println("Enter the state name to view contacts: ");
		Scanner scanner = new Scanner(System.in);
		String state = scanner.nextLine();
		person.stream().filter(map -> map.getState().contains(state))
				.forEach(persons -> System.out.println("Name: " + persons.getFname() + persons.getLname()));
	}

	public static void countByCity(List<Person> person) {
		System.out.println("Enter the city name to count the contacts for: ");
		Scanner scanner = new Scanner(System.in);
		String city = scanner.next();
		Long countNamesByCity = person.stream().filter(e -> city.equals(e.getCity())).count();
		System.out.println(city + " : " + countNamesByCity);
	}

	public static void countByState(List<Person> person) {
		System.out.println("Enter the state name to count the contacts for: ");
		Scanner scanner = new Scanner(System.in);
		String state = scanner.next();
		Long countNamesByState = person.stream().filter(e -> state.equals(e.getState())).count();
		System.out.println(state + " : " + countNamesByState);
	}

	public static void sortedPersonByFirstName(List<Person> person) {
		List<Person> sortedPerson = person.stream().sorted(new ComparePersons()).collect(Collectors.toList());
		System.out.println(sortedPerson);
	}

	public static void sortedPersonByCity(List<Person> person) {
		person.stream().sorted(new CompareCity()).forEach(System.out::println);
	}

	public static void sortedPersonByState(List<Person> person) {
		person.stream().sorted(new CompareState()).forEach(System.out::println);
	}

	public static void sortedPersonByZip(List<Person> person) {
		person.stream().sorted(new CompareZip()).forEach(System.out::println);
	}

	// AddressBookOperations
	public void createBook(String bookName, HashMap<String, ArrayList<Person>> addressBooks) {
		Scanner scanner = new Scanner(System.in);
		if (addressBooks.containsKey(bookName)) {
			System.out.println("Address book with the same name already exist.");
			System.out.println("Provide different name: ");
			bookName = scanner.nextLine();
			addressBookCheck(addressBooks, bookName);
		} else
			addressBooks.put(bookName, new ArrayList<Person>());
	}

	public void displayAllAddressBooks(HashMap<String, ArrayList<Person>> addressBooks) {
		System.out.println(addressBooks);
		System.out.println();
	}

	public void displayAddressBooks(HashMap<String, ArrayList<Person>> addressBooks) {
		boolean is_Empty = addressBooks.isEmpty();
		if (is_Empty == true) {
			System.out.println("No record(s) found.");
		} else {
			System.out.println(addressBooks);
			System.out.println();
		}
	}

	public int addressBookCheck(HashMap<String, ArrayList<Person>> addressBooks, String addressBookName) {
		if (addressBooks.containsKey(addressBookName))
			return 1;
		else
			return 0;
	}

	public void editAddressBook(HashMap<String, ArrayList<Person>> addressBooks, String addressBookName) {
		ArrayList<Person> records = addressBooks.get(addressBookName);
	}
}