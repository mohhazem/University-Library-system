package backend;

public class BookDatabase extends Database {

    public BookDatabase(String filename) {
        super(filename);
    }

    public String getFileName() {
        return this.filename;
    }

    @Override
    public Book createRecordFrom(String line) {
        String Split[] = line.split(",");
        return new Book(Split[0], Split[1], Split[2], Split[3],
                Integer.parseInt(Split[4]));
    }

}
