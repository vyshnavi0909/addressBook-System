import java.util.*;

public class AddressBookMain {

    static String fn, ln, cn, sn, eid;
    static long pin, phN;
    static int d;
    static String firstPerson, secondPerson;

    //reading input for string variables for contact info
    static String userInput1(String a){
        Scanner scan = new Scanner(System.in);
        System.out.println(a);
        String x = scan.nextLine();
        return x;
    }

    //reading input for long variables for contact info
    static long userInput2(String a){
        Scanner scan = new Scanner(System.in);
        System.out.println(a);
        long y = scan.nextLong();
        return y;
    }

    //assigning variables to pass into the contacts
    static void inputCall(){
        fn = userInput1("First Name: ");
        ln = userInput1("Last Name: ");
        cn = userInput1("City: ");
        sn = userInput1("State: ");
        pin = userInput2("Zip: ");
        phN = userInput2("phoneNumber: ");
        eid = userInput1("Email id: ");
    }

    //providing options for user to select "what to do next?"
    static void options(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What action do you want to perform next? \n1).Add another person details \n2).Edit the existing person details. \n3).Delete the person details. \n4).For exiting.");
        d = scan.nextInt();
    }

    static void toChangeDetails(Contacts obj){
        Scanner input = new Scanner(System.in);
        System.out.println("Which one do you want to change? \n1).First Name \n2).Last Name \n3).City \n4).State \n5).Zip \n6).Phone Number \n7).Email ID \n");
        int userChoice = input.nextInt();
    
        //asking user for new value for selected detail
        Scanner scan = new Scanner(System.in);
    
        switch(userChoice){
            case 1:
                System.out.println("Enter new first name:");
                String newFName = scan.nextLine();
                obj.firstName =  newFName;
                break;
            case 2:
                System.out.println("Enter new last name:");
                String newLName = scan.nextLine();
                obj.lastName =  newLName;
                break;
            case 3:
                System.out.println("Enter new city:");
                String newCity = scan.nextLine();
                obj.cityName =  newCity;
                break;
            case 4:
                System.out.println("Enter new state:");
                String newState = scan.nextLine();
                obj.state =  newState;
                break;
            case 5:
                System.out.println("Enter new zip code:");
                long newZip = scan.nextLong();
                obj.zip =  newZip;
                break;
            case 6:
                System.out.println("Enter new phone number:");
                long newPhNum = scan.nextLong();
                obj.phoneNum =  newPhNum;
                break;
            case 7:
                System.out.println("Enter new email id:");
                String newEmail = scan.nextLine();
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
        
        AddressBookMain.options(); //selecting options
        while(d<4){  
            //switch-case for checking users selected option
            switch(d){
            case 1: //adding another person details
                    AddressBookMain.inputCall();
                    Contacts newPerson = new Contacts(fn, ln, cn, sn, pin, phN, eid);
                    newPerson.show();
                    break;

            case 2: //edit person details
                //asking user which detail to edit
                
                Scanner scan = new Scanner(System.in);
                System.out.println("Whose details u wanna change? \n1)."+ firstPerson + "\n2)."+ secondPerson);

                int opt1 = scan.nextInt();
                if(opt1 == 1){
                    AddressBookMain.toChangeDetails(person);
                    System.out.println("Succesfully edited " + firstPerson);
                }if(opt1 == 2){
                    AddressBookMain.toChangeDetails(person2);
                    System.out.println("Succesfully edited " + secondPerson);
                }
                
                break;
            
            case 3: // delete person details
                Scanner input = new Scanner(System.in);
                System.out.println("Whose details u wanna change? \n1)."+ firstPerson + "\n2)."+ secondPerson);
                int opt = input.nextInt();
                if(opt == 1){
                    person = null;
                    System.out.print("successfully deleted " + firstPerson );
                }
                if(opt == 2){
                    person2 = null;
                    System.out.println("successfully deleted "+ secondPerson);
                }
                 
            break;
            default:
                System.out.println("Invalid");
                break;
            }
            
            AddressBookMain.options(); //asking for next action
        }
    }
    
}

//contacts class
class Contacts{

    String firstName, lastName, cityName, state, email;
    long zip;
    long phoneNum;
    String a, s1, s2;

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
        //s2 substring contains remaining letters of string
        String s2 = a.substring(1, a.length());
    
        // changing the first letter to uppercase
        s1 = s1.toUpperCase();
    
        // joining the two substrings
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