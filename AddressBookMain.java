public class AddressBookMain {


	public static void main(String[] args){
		System.out.println("Welcome to Address Book Program");
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
