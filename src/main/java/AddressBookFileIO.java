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

}