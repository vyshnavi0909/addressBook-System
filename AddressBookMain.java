import java.util.*;

public class AddressBookMain {


   static String UserInput1(String a){
      Scanner input = new Scanner(System.in);
      System.out.println(a);
		String x = input.nextLine();
		return x;
   }

	static long UserInput2(String a){
		Scanner input = new Scanner(System.in);
      System.out.println(a);
      long y = input.nextLong();
      return y;
   }

	public static void main(String[] args){
		System.out.println("Welcome to Address Book Program");

		String fn = UserInput1("First Name: ");
		String ln = UserInput1("Last Name: ");
		String addrs = UserInput1("Address: ");
		String cn = UserInput1("City: ");
		String sn = UserInput1("State: ");
		long pin = UserInput2("Zip: ");
		long phN = UserInput2("phoneNumber: ");
		String eid = UserInput1("Email id: ");

		Contacts n = new Contacts(fn, ln, addrs, cn, sn, pin, phN, eid);

      System.out.println("Name: " + n.firstName + " " + n.lastName );
      System.out.println("Address: " + n.address + ", " + n.cityName + ", " + n.state + ", " + n.zip );
      System.out.println("Contact number: " + n.phoneNum);
      System.out.println("Email id: " + n.email);

	}
}


class Contacts{

	String firstName, lastName, address, cityName, state, email;
	long zip;
	long phoneNum;

	Contacts(String fN, String lN, String addr, String city, String st, long z, long pNum, String eId){
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
