import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
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

    @Override
    public String toString() {
        String result = "------- "+ this.getName()+ " -------\n";
        result+=contents;
        result+="\n------------------------------\n";
        result+=this.getDate();
        return result;
    }

    public void export(String fileName) throws IOException {
        Files.writeString(Path.of(fileName), this.toString());
    }

}
