
public class Person {
	private final String firstName; // Can't be edited so private and final
	private final String lastName; // Can't be edited so private and final
	private String phoneNumber;
	private String address;
	private String city;
	private String state;
	private int zip;

	public Person(String firstName, String lastName, String phoneNumber, String address, String city, String state,
			int zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getFname() {
		return this.firstName;
	}

	public String getLname() {
		return this.lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPin() {
		return zip;
	}

	public void setPin(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
}
