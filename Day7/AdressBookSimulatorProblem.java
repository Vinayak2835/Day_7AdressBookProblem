package com.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Contact
{
    //private global variables
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String email;

    //initializing global variables
    public Contact(String f_name, String l_name, String address, String city, String state, int zip, long phoneNumber, String email)
    {
        firstName = f_name;
        lastName = l_name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //to add first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //to add last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //to add address
    public void setAddress(String address) {
        this.address = address;
    }

    //to add city
    public void setCity(String city) {
        this.city = city;
    }

    //to add state
    public void setState(String state) {
        this.state = state;
    }

    //to add zip
    public void setZip(int zip) {
        this.zip = zip;
    }

    //to add phone number
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //to add email
    public void setEmail(String email) {
        this.email = email;
    }

    //to fetch first name
    public String getFirstName() {
        return firstName;
    }

    //to fetch last name
    public String getLastName() {
        return lastName;
    }

    //to fetch address
    public String getAddress() {
        return address;
    }

    //to fetch city
    public String getCity() {
        return city;
    }

    //to fetch state
    public String getState() {
        return state;
    }

    //to fetch zip
    public int getZip() {
        return zip;
    }

    //to fetch phone number
    public long getPhoneNumber() {
        return phoneNumber;
    }

    //to fetch email
    public String getEmail() {
        return email;
    }

    //to fetch everything
    @Override //for getting all the info
    public String toString() {
        return "member info:"+"\n"+ "firstName: " + firstName +"\n"+"lastName: " + lastName +"\n"+ "address: " + address +"\n"+ "city: " + city +"\n"+ "state: " + state +"\n"+ "zip: " + zip +"\n"+ "phoneNumber: " + phoneNumber +"\n"+ "email: " + email;
    }
}


class AddressBookMembers
{
    //creating a list for members
    private List<Contact> members;
    /**
     * members = list of members
     */
    HashMap<Contact, List<Contact>> map = new HashMap<>();

    //assigning members to the list
    public AddressBookMembers(List<Contact> members)
    {
        this.members = members;
    }

    //Returns the list of members
    public List<Contact> getContact()
    {
        return members;
    }

    //Adds a new member to the members list
    public void setMember(List<Contact> member)
    {
        this.members = member;
        map.put(member.get(0), member);
    }

    //Returns the contact by name
    public List<Contact> getByName(String name)
    {
    	return map.get(name);
    }
}

public class AdressBookSimulatorProgram
{
    static int i;
    static List<Contact> membersList;
    static AddressBookMembers abms;
    static Scanner sc;
    static Contact Vinay;
    static Contact varun;
    static Contact object;

    public static int optionToUpdate(Object object)
    {
        Contact anObject = (Contact) object;
        sc = new Scanner(System.in);
        System.out.println("Which detail do you want to change?");
        System.out.println("1. first name" +"\n"+"2. last name"+"\n"+
                           "3. address"+"\n"+"4. city"+"\n"+"5. state"+"\n"+
                           "6. zip"+"\n"+"7. phone number"+"\n"+"8. email"+"\n"+
                           "9. exit");
        int option =sc.nextInt();
        sc = new Scanner(System.in);
        switch(option)
        {
            case 1:
                System.out.println("Enter the first name:");
                anObject.setFirstName(sc.nextLine());
                break;
            case 2:
                System.out.println("Enter the last name: ");
                anObject.setLastName(sc.nextLine());
                break;
            case 3:
                System.out.println("Enter the Address: ");
                anObject.setAddress(sc.nextLine());
                break;
            case 4:
                System.out.println("Enter the city");
                anObject.setCity(sc.nextLine());
                break;
            case 5:
                System.out.println("Enter the state");
                anObject.setState(sc.nextLine());
                break;
            case 6:
                System.out.println("Enter the zip");
                anObject.setZip(sc.nextInt());
                break;
            case 7:
                System.out.println("Enter the phone number");
                anObject.setPhoneNumber(sc.nextLong());
                break;
            case 8:
                System.out.println("Enter the email");
                anObject.setEmail(sc.nextLine());
                break;
            default:
                System.out.println("Thank you");
        }
        return 0;
    }

    //main method
    public static void main(String[] args)
    {
        //Entering the details manually
        Vinay= new Contact("Vinay", "Naik", "H.No: 1-4-5/2, Near post office, Honavar.", "Banglore", "Karnataka", 581334, 9865895652L, "email1@yahoo.com");

        //Creating a list for the contacts
        membersList = new ArrayList<>();

        //Adding member to the contact list
        membersList.add(Vinay);

        //Passing the contacts list to the address book
        abms = new AddressBookMembers(membersList);

        //printing the contact details from Contacts list
        System.out.println("Contact: "+abms.getContact());


        //Taking the details from user
        sc = new Scanner(System.in);

        System.out.println("Enter member's first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter member's last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter member's address: ");
        String address = sc.nextLine();
        System.out.println("Enter city: ");
        String city = sc.nextLine();
        System.out.println("Enter state: ");
        String state = sc.nextLine();
        System.out.println("Enter zip: ");
        int zip = sc.nextInt();
        System.out.println("Enter phone number: ");
        long phoneNumber = sc.nextLong();

        //Passing variables/details to the Contact-class
        varun = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);

        //Adding member to the contact list
        membersList.add(varun);

        //printing the contact details from Contacts list
       //System.out.println("Contact: "+abms.getContact());

        System.out.println("Do you want to update details? : Y/N");
        sc = new Scanner(System.in);

        //choosing the option
        switch(sc.nextLine().toUpperCase())//converting the option to upper-case
        {
            case "Y":
                System.out.println("Which persons details do you want to update?"+"\n"+" 1. person_1"+"\n"+" 2. person_2");
                System.out.println("Enter the number: ");
                switch(sc.nextInt())
                {
                    case 1:
                        //updating person_1
                        object = Vinay; //passing reference to a reference
                        optionToUpdate(object);
                        break;
                    case 2:
                        //Updating person_2
                        object = varun; //passing reference to a reference
                        optionToUpdate(object);
                        break;
                    default:
                        System.out.println("Sorry! this program is for two persons only!");
                }
            default:
                System.out.println("Thank you!");
        }

       //System.out.println("Contact: "+abms.getContact());
        System.out.println(abms.getByName("Vinay"));

        System.out.println("Do yopu want to delete the last list entered?: Y/N");
        sc = new Scanner(System.in);
        String delete = sc.nextLine().toUpperCase();
        if("Y".equals(delete))
        {
        	System.out.println("Which persons details do you want to delete?"+"\n"+" 1. person_1"+"\n"+" 2. person_2");
        	System.out.println("Enter the number: ");
        	switch(sc.nextInt())
        	{
        		case 1:
        			//updating person_1
        			object = Vinay; //passing reference to a reference
        			membersList.remove(object);
        			break;
        		case 2:
        			//Updating person_2
        			object = varun; //passing reference to a reference
        			membersList.remove(object);
        			break;
        		default:
        			System.out.println("Sorry! this program is for two persons only!");
        	}
        	System.out.println("contact deleted from the Address Book!");
        }
        // System.out.println("Contact: "+abms.getContact());

    }
}
