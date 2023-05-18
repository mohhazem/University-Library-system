package backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class StudentBookDatabase extends Database {

    public StudentBookDatabase(String filename) {
        super(filename);
    }

    @Override
    public  StudentBook createRecordFrom(String line) {
        String Split[] = line.split(",");
        String date = Split[2];
        String Split2[] = date.split("-");
        int year= Integer.parseInt (Split2[0]);
        int month= Integer.parseInt(Split2[1]);
        int day= Integer.parseInt(Split2[2]);
        LocalDate localDate = LocalDate.of(year, month, day);
        StudentBook b = new StudentBook(Split[0], Split[1], localDate);
        return b;
    }
}
