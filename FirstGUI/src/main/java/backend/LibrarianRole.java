package backend;


//import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LibrarianRole {
    private StudentBookDatabase sBDatabase;
    private BookDatabase booksDatabase;

    public LibrarianRole() {
        sBDatabase = new StudentBookDatabase(Constants.FileNames.STUDENTSBOOKS_FILENAME);
        booksDatabase = new BookDatabase(Constants.FileNames.BOOKS_FILENAME);
        //sBDatabase.readFromFile();
        //booksDatabase.readFromFile();
    }

    public void addBook(String id, String title, String authorName, String publisherName, int quantity) {
        Book b = new Book(id, title, authorName, publisherName, quantity);
        booksDatabase.readFromFile();
        booksDatabase.insertRecord(b);
    }

    public Book[] getListOfBooks() {
        booksDatabase.readFromFile();
        ArrayList<Record> records = booksDatabase.returnAllRecords();
        return records.toArray(new Book[records.size()]);
    }

    public StudentBook[] getListOfBorrowingOperations() {
        sBDatabase.readFromFile();
        ArrayList<Record> records = sBDatabase.returnAllRecords();
        return records.toArray(new StudentBook[records.size()]);
    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowDate) {
        sBDatabase.readFromFile();
        booksDatabase.readFromFile();
        if (!booksDatabase.contains(bookId)) {
            return -1;
        }
        Book m = (Book) booksDatabase.getRecord(bookId);
        if (sBDatabase.contains((studentId + "," + bookId))) {
            return 1;
        } else if ((m.getQuantity()) == 0) {
            return 0;
        } else {
            m.setQuantity((m.getQuantity() - 1));
            sBDatabase.insertRecord(sBDatabase.createRecordFrom(studentId + "," + bookId + "," + borrowDate));
            return 2;
        }
    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate) {
        sBDatabase.readFromFile();
        booksDatabase.readFromFile();
        if (!sBDatabase.contains(studentId + "," + bookId)) {
            return -1;
        }
        Book book = (Book) booksDatabase.getRecord(bookId);
        book.setQuantity(book.getQuantity() + 1);

        StudentBook borrowOperation = (StudentBook) sBDatabase.getRecord(studentId + "," + bookId);
        LocalDate date = borrowOperation.getBorrowDate();
        double delay = ChronoUnit.DAYS.between(date,returnDate );
        sBDatabase.deleteRecord(studentId + "," + bookId);
        if (delay <= 7) {
            System.out.println(delay);
            return 0;
            
        } else {
            System.out.println(delay);
            return (delay - 7) * 0.5;
        }
    }

    public void logout() {
        booksDatabase.saveToFile();
        sBDatabase.saveToFile();
    }

}
