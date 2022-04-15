import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

// for reference to see all methods used
public interface AddressBookIF {
    public void addContacts();
    public void edit();
    public void delete();
    public void display();
    public void searchByCity(String city,String firstName);
    public void searchByState(String state, String firstName);
    public void personsInCity(String city);
    public void personsInState(String State);
    public  void sortByFirstName();
    public  void sortByZip();
    public  void sortByCity();
    public  void sortByState();
    public void writeDataToJson() throws IOException;
    public void readDataFromJson() throws IOException;
    public void writeDataToCSV() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;
    public <CsvValidationException extends Throwable> void readDataFromCSV() throws IOException, CsvValidationException;
}