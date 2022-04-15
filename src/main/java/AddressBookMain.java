import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
    private static List<AddressBook> addressBooks = new LinkedList<AddressBook>();
    private static String[] addressBookName = new String[10];
    private static int  numOfBooks =0;
    public static AddressBookFileIO addressBookFileIO = new AddressBookFileIO();

    // checks if the address book with name exits or not
    private boolean checkName(String name) {
        for(int i=0;i<addressBooks.size();i++) {
            if(addressBookName[i].equals(name))
                return true;
        }
        return false;
    }

    // shows menu of operations to user and gets input
    private static void addressMenu(AddressBook addressBook) throws Exception {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean exit = true;
        while(exit) {
            System.out.println("Select option\n 1: add user. \n 2: edit existing user."
                    + "\n 3: display all users \n 4:Delete contact. \n 5:seach userby city "
                    + "\n 6: search user by state. \n 7:view by city \n 8:view by state"
                    + "\n 9: sort by name \n 10:sort by zip \n 11: sort by city "
                    + "\n 12: sort by state \n 13:Switch Address Book"
                    + "\n 13: Write to file"
                    + "\n 14. Read from file"
                    + "\n 15. Write to CSV"
                    + "\n 16. Read from CSV"
                    + "\n 17. Write to JSON"
                    + "\n 18. Read from JSON");
            option  = sc.nextInt();
            switch(option) {
                case 1 :
                    addressBook.addContacts();
                    break;
                case 2 :
                    System.out.println("Enter the first name to edit");
                    addressBook.edit();
                    break;
                case 3:
                    System.out.println("display");
                    addressBook.display();
                    break;
                case 4:
                    System.out.println("Enter name");
                    addressBook.delete();
                    break;
                case 5:
                    System.out.println("enter the name of the city");
                    String cityName = sc.next();
                    System.out.println("enter the first name to search for city");
                    String firstName = sc.next();

                    addressBook.searchByCity(cityName,firstName);
                case 6:
                    System.out.println("enter the name of the city");
                    String stateName = sc.next();
                    System.out.println("enter the first name to search for city");
                    String firstName1 = sc.next();
                    addressBook.searchByState(stateName,firstName1);
                    break;
                case 7:
                    System.out.println("enter the city name");
                    String city  = sc.next();
                    addressBook.personsInCity(city);
                    break;
                case 8:
                    System.out.println("enter the state name");
                    String state  = sc.next();
                    addressBook.personsInState(state);
                    break;
                case 9:
                    addressBook.sortByFirstName();
                    break;
                case 10:
                    addressBook.sortByZip();
                    break;
                case 11:
                    addressBook.sortByCity();
                    break;
                case 12:
                    addressBook.sortByState();
                    break;
                case 13:
                    addressBook.write();
                    break;
                case 14:
                    List<String> listaddressBook = addressBook.read();
                    break;
                case 15:
                    try
                    {
                        addressBook.writeDataToCSV();
                    }catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
                        e.printStackTrace();
                    }
                    break;
                case 16:
                    try {
                        addressBook.readDataFromCSV();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 17:
                    try {
                        addressBook.writeDataToJson();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;

                case 18:
                    try {
                        addressBook.readDataFromJson();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;

                default:
                    exit = false;

            }
            System.out.println();
        }
    }

    // main method initially ask user to add new book or open existing book
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to address book program");
        Scanner sc = new Scanner(System.in);

        AddressBook currentBook;
        int choice =0;
        boolean exit1 = true;
        while(exit1) {
            System.out.println("Select option 1:Add address Book 2:open Address Book 3:exit");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter the address book name");
                    String name = sc.next();
                    currentBook  = new AddressBook();
                    currentBook.setAdressBookName(name);
                    addressBooks.add(currentBook);

                    addressBookName[numOfBooks] = name;
                    numOfBooks++;
                    break;
                case 2:
                    System.out.println("The Address books available :");
                    for(int i=0;i<numOfBooks;i++) {
                        System.out.println(addressBookName[i]);
                    }
                    System.out.println("Enter the address book name");
                    String bookName = sc.next();
                    int i =0;
                    for(i=0;i<numOfBooks;i++) {
                        if(addressBookName[i].equals(bookName)) break;
                    }

                    if(i == numOfBooks) {
                        System.out.println("name Not Found");
                        break;
                    }
                    currentBook = addressBooks.get(i);
                    addressMenu(currentBook);
                    break;
                default:
                    exit1 = false;
            }
        }

        sc.close();
    }
}