package backend;



public class Book implements Record {
    private String bookID;
    private String title;
    private String authorName;
    private String publisherName;
    private int quantity;

    public Book(String bookID, String title, String authorName, String publisherName, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String lineRepresentation() {
        return (bookID + "," + title + "," + authorName + "," + publisherName + "," + quantity);
    }

    @Override
    public String getSearchKey() {
        return bookID;
    }

}
