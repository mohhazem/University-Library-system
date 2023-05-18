package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LibrarianUserDatabase extends Database {
    public LibrarianUserDatabase(String filename) {
        super(filename);
    }

    public String getFileName() {
        return this.filename;
    }

    public LibrarianUser createRecordFrom(String line) {
        String[] split = line.split(",");
        LibrarianUser s = new LibrarianUser(split[0], split[1], split[2], split[3], split[4]);
        return s;
    }

}