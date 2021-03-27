import java.util.*;

public class AddressBookMain {

    static String fn, ln, cn, sn, eid;
    static long pin, phN;
    static int d;
    static String firstPerson, secondPerson;

    //reading input for string variables for contact info
    static String UserInput1(String a){
        Scanner scan = new Scanner(System.in);
        System.out.println(a);
        String x = scan.nextLine();
        return x;
    }

    //reading input for long variables for contact info
    static long UserInput2(String a){
        Scanner scan = new Scanner(System.in);
        System.out.println(a);
        long y = scan.nextLong();
        return y;
    }

    //assigning variables to pass into the contacts
    static void inputCall(){
        fn = UserInput1("First Name: ");
        ln = UserInput1("Last Name: ");
        cn = UserInput1("City: ");
        sn = UserInput1("State: ");
        pin = UserInput2("Zip: ");
        phN = UserInput2("phoneNumber: ");
        eid = UserInput1("Email id: ");
    }

    //providing options for user to select "what to do next?"
    static void Options(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What action do you want to perform next? \n1).Add another person details \n2).Edit the existing person details. \n3).For exiting.");
        d = scan.nextInt();
    }

    //providing another option after deleting the object/person details
    // static void AfterDeleteOption(){
    //     Scanner newOpt = new Scanner(System.in);
    //     System.out.println("Do you want to add new person's details?\n 1).Yes \n 2).No");
    //     int opt = newOpt.nextInt();
    //     if(opt == 1){
    //         AddressBookMain.inputCall();
    //     }
    // }

    static void ToChangeDetails(Contacts obj){
        Scanner uc = new Scanner(System.in);
        System.out.println("Which one do you want to change? \n 1).First Name \n 2).Last Name \n 3).City \n 4).State \n 5).Zip \n 6).Phone Number \n 7).Email ID \n");
        int userChoice = uc.nextInt();
    
        //asking user for new value for selected detail
        Scanner input1 = new Scanner(System.in);
    
        switch(userChoice){
            case 1:
                System.out.println("Enter new first name:");
                String newFName = input1.nextLine();
                obj.firstName =  newFName;
                break;
            case 2:
                System.out.println("Enter new last name:");
                String newLName = input1.nextLine();
                obj.lastName =  newLName;
                break;
            case 3:
                System.out.println("Enter new city:");
                String newCity = input1.nextLine();
                obj.cityName =  newCity;
                break;
            case 4:
                System.out.println("Enter new state:");
                String newState = input1.nextLine();
                obj.state =  newState;
                break;
            case 5:
                System.out.println("Enter new zip code:");
                long newZip = input1.nextLong();
                obj.zip =  newZip;
                break;
            case 6:
                System.out.println("Enter new phone number:");
                long newPhNum = input1.nextLong();
                obj.phoneNum =  newPhNum;
                break;
            case 7:
                System.out.println("Enter new email id:");
                String newEmail = input1.nextLine();
                obj.email = newEmail;
                break;
            default:
                System.out.println("invalid choice");
                break;
        }
                obj.show();//prints the new details

    }

    //main method
    public static void main(String[] args){

        System.out.println("Welcome to Address Book Program");

        System.out.println("Enter first person's details");
        AddressBookMain.inputCall(); //calling input parameter
        Contacts person = new Contacts(fn, ln, cn, sn, pin, phN, eid); //creating new object of person and assigning values
        person.show(); //prints details
        firstPerson = person.firstName;

        System.out.println("Enter another person's details");
        AddressBookMain.inputCall(); //calling input parameter
        Contacts person2 = new Contacts(fn, ln, cn, sn, pin, phN, eid); //creating new object of person and assigning values
        person2.show(); //prints details
        secondPerson=person2.firstName;
        
        AddressBookMain.Options(); //selecting options
        while(d<3){
            
            //switch-case for checking users selected option
            switch(d){
            case 1: //adding another person details
                    AddressBookMain.inputCall();
                    Contacts newPerson = new Contacts(fn, ln, cn, sn, pin, phN, eid);
                    newPerson.show();
                    break;

            case 2: //edit person details
                //asking user which detail to edit
                
                Scanner input = new Scanner(System.in);
                System.out.println("Whose details u wanna change? \n 1)."+ firstPerson + "\n2)."+ secondPerson);

                int opt1 = input.nextInt();
                if(opt1 == 1){
                    AddressBookMain.ToChangeDetails(person);
                }if(opt1 == 2){
                    AddressBookMain.ToChangeDetails(person2);
                }
                break;

            default:
                System.out.println("Invalid");
                break;
            }
            
            AddressBookMain.Options(); //asking for next action
        }
    }
}
//contacts class
class Contacts{

    static String firstName, lastName, cityName, state, email;
    static long zip;
    static long phoneNum;
    static String a, s1, s2;

    //constructor to assign the values for details
    Contacts(String fn, String ln, String cn, String sn, long pin, long phN, String eid){
        firstName = fn;
        lastName = ln;
        cityName = cn;
        state = sn;
        zip = pin;
        phoneNum = phN;
        email = eid;
    }

    //method to make first letter of names to upper case
    static String letterToUpperCase(String a){
        //s1 substring contains first letter of string a
        String s1 = a.substring(0, 1);
        //s2 substring contains remaining letters of string a except first
        String s2 = a.substring(1, a.length());
    
        // change the first letter to uppercase
        s1 = s1.toUpperCase();
    
        // join the two substrings
        a = s1 + s2;
        return a;
    }
    //method for printing details
    void show() {

        System.out.println("\nFull Name: " + Contacts.letterToUpperCase(firstName) + " " + Contacts.letterToUpperCase(lastName));
        System.out.println("City: " + Contacts.letterToUpperCase(cityName));
        System.out.println("State: " + Contacts.letterToUpperCase(state) );
        System.out.println("Zip Code: " + zip);
        System.out.println("Phone Number : " + phoneNum);
        System.out.println("Email ID: " + email + "\n");
    }
}
