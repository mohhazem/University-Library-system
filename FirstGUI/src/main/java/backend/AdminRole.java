package backend;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdminRole {
    private LibrarianUserDatabase database;

    public AdminRole() {
        database = new LibrarianUserDatabase(Constants.FileNames.LIBRARIANS_FILENAME);
        database.readFromFile();
    }

    /*
     * public LibrarianUserDatabase getdbase() {
     * return database;
     * }
     */
    public void setDatabase(LibrarianUserDatabase database) {
        this.database = database;
    }

    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber) {
        LibrarianUser S = new LibrarianUser(librarianId, name, email, address, phoneNumber);
        database.insertRecord(S);
        //database.saveToFile();
    }

    public LibrarianUser[] getListOfLibrarians() {
        ArrayList<Record> records = database.returnAllRecords();
        return records.toArray(new LibrarianUser[records.size()]);
    }

    public void removeLibrarian(String key) {
        database.deleteRecord(key);
    }

    public void logout() {
        database.saveToFile();
    }

}
