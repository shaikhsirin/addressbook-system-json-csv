import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileIO {
    // write data into txt file
    public static void writeData(List<ContactPerson> addressBook, String filename) {

        StringBuffer addressBookBuffer = new StringBuffer();
        addressBook.forEach(ContactPerson -> {
            String addressBookString = ContactPerson.toString().concat("\n");
            addressBookBuffer.append(addressBookString);
        });

        try {
            Files.write(Paths.get(filename), addressBookBuffer.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //read data from text file
    public static List<String> readDataFromFile(String filename) {

        List<String> addressBookList = new ArrayList<String>();
        String bookName = filename;
        String fileName = bookName + ".txt";
        System.out.println("Reading from : " + fileName + "\n");
        try {
            Files.lines(new File(fileName).toPath())
                    .map(line -> line.trim())
                    .forEach(employeeDetails -> {
                        System.out.println(employeeDetails);
                        addressBookList.add(employeeDetails);
                    });

        }
    }
}
