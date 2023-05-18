package backend;

import java.time.LocalDate;

public class StudentBook implements Record {
    private String studentID;
    private String bookID;
    private LocalDate borrowDate;

    public StudentBook(String studentID, String bookID, LocalDate borrowDate) {
        this.studentID = studentID;
        this.bookID = bookID;
        this.borrowDate = borrowDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getBookID() {
        return bookID;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    @Override
    public String lineRepresentation() {
        return (this.getStudentID() + "," + this.getBookID() + "," + this.getBorrowDate());
    }

    @Override
    public String getSearchKey() {
        return (this.getStudentID() + "," + this.getBookID());
    }

}
