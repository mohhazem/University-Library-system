package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public abstract  class Database {
    protected ArrayList<Record> records = new ArrayList<Record>();
    protected String filename;

    public Database(String filename) {
        this.filename = filename;
    }

    public void readFromFile() {

        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                // String[] s1 = sc.nextLine().split(",");
                // LibrarianUser Librarian = new LibrarianUser(s1[0], s1[1], s1[2], s1[3],
                // s1[4]);
                String l = sc.nextLine();
                this.insertRecord(createRecordFrom(l));
            }
            sc.close();
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public abstract Record createRecordFrom(String line);

    public ArrayList<Record> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {

        for (int i = 0; i < records.size(); i++) {
            if (key.equals(records.get(i).getSearchKey()))
                return true;
        }
        return false;
    }

    public void insertRecord(Record s) {
        if (contains(s.getSearchKey()) == false) {
            records.add(s);
            // System.out.println("Record is added successfully");
           //  JOptionPane.showMessageDialog(null, "ID Added");
        }
        
            //else
               // JOptionPane.showMessageDialog(null, "ID registered before");

    }

    public void deleteRecord(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (key.equals(records.get(i).getSearchKey())) {
                records.remove(i);
                System.out.println("records has been removed successfully");
                return;
            }
        }
        System.out.println("Record can't be found");
    }

    public void saveToFile() {

        try {
            PrintWriter writer = new PrintWriter(filename);
            for (int i = 0; i < records.size(); i++)
                writer.println(records.get(i).lineRepresentation());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Record getRecord(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (key.equals(records.get(i).getSearchKey()))
                return records.get(i);
        }
        System.out.println("ID not found");
        return null;

    }
}
