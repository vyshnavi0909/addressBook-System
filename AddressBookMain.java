public class AddressBookMain {


	public static void main(String[] args){
		System.out.println("Welcome to Address Book Program");

		Contacts x = new Contacts("Vyshu", "Goud", "Go Green Heights", "Hyd", "Telangana", 500010, 9700000099L, "vyshugoud11@gmail.com");

      System.out.println("Name: " + x.firstName + " " + x.lastName );
      System.out.println("Address: " + x.address + ", " + x.cityName + ", " + x.state + ", " + x.zip );
      System.out.println("Contact number: " + x.phoneNum);
      System.out.println("Email id: " + x.email);

	}
}

class Contacts{

	String firstName, lastName, address, cityName, state, email;
	int zip;
	long phoneNum;

	Contacts(String fN, String lN, String addr, String city, String st, int z, long pNum, String eId){
		firstName = fN;
		lastName = lN;
		address = addr;
		cityName = city;
		state = st;
		zip = z;
		phoneNum = pNum;
		email = eId;

	}
}
