import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MenuHandler handler = new MenuHandler();
        handler.loadFromFile();
        handler.showMenu();
    }
}
