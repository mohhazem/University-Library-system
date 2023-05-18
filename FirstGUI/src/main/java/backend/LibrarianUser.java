package backend;



public class LibrarianUser implements Record {
    private String librarianId;
    private String Name;
    private String Email;
    private String Address;
    private String PhoneNumber;

    public LibrarianUser(String librarianId, String Name, String Email, String Address, String PhoneNumber) {
        this.librarianId = librarianId;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public String lineRepresentation() {
        return (librarianId + "," + Name + "," + Email + "," + Address + "," + PhoneNumber);
    }

    @Override
    public String getSearchKey() {
        return librarianId;
    }

}
