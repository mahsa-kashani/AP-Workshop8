import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    private String name;
    private String contents;
    private String date;

    public Note(String name, String contents) {
        this.name = name;
        this.contents = contents;
        this.date = new Date().toString();
    }

    public String getName() {
        return name;
    }

    public String getContents() {
        return contents;
    }

    public String getDate() {
        return date;
    }
}
