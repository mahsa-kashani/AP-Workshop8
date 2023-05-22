import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuHandler {
    private NotesHandler notesHandler = new NotesHandler();
    private static final Scanner sc = new Scanner(System.in);

    public void showMenu() throws IOException {
        String menuText = "\n1 - Add\n" + "2- Remove\n" + "3- Notes\n" + "4- Export\n";
        System.out.println(menuText);
        int chosen = Integer.parseInt(sc.nextLine());
        if(chosen == 1){
            System.out.println("Please enter the name of the note : ");
            String name = sc.nextLine();
            System.out.println("Please enter the contents of the note : ");
            System.out.println("enter # to finish!");
            String overalContent = "";
            String contents = sc.nextLine();
            while(!contents.equals("#")){
                overalContent += contents+"\n";
                contents = sc.nextLine();
            }
            try {
                notesHandler.addNote(name, overalContent);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else if(chosen == 2){
            ArrayList<Note> notes = notesHandler.getNotes();
            int len = notes.size();
            for(int i = 1 ; i<=len ; i++){
                System.out.println(i + "- " + notes.get(i-1).getName() + "\t" + notes.get(i-1).getDate());
            }
            System.out.println("Choose the number to remove : ");
            int ind = Integer.parseInt(sc.nextLine());
            notesHandler.removeNote(ind-1);
        }
        else if (chosen == 3){
            ArrayList<Note> notes = notesHandler.getNotes();
            int len = notes.size();
            for(int i = 1 ; i<=len ; i++){
                System.out.println(i + "- " + notes.get(i-1).getName() + "\t" + notes.get(i-1).getDate());
            }
            System.out.println("Choose a note to show : ");
            int ind = Integer.parseInt(sc.nextLine());
            Note note = notesHandler.getNote(ind-1);
            System.out.println("-------  "+note.getName()+"  ---------");
            System.out.println(note.getContents());
        }
        else if (chosen == 4){
            ArrayList<Note> notes = notesHandler.getNotes();
            int len = notes.size();
            for(int i = 1 ; i<=len ; i++){
                System.out.println(i + "- " + notes.get(i-1).getName() + "\t" + notes.get(i-1).getDate());
            }
            System.out.println("Choose a note to show : ");
            int ind = Integer.parseInt(sc.nextLine());
            notesHandler.getNote(ind-1).export(notesHandler.getNote(ind-1).getName()+".txt");
            System.out.println("Saved successfully");
        }
        else{
            System.out.println("Option is not valid! Terminating...");
            return;
        }
        showMenu();
    }

    public void loadFromFile() {
        try {
            this.notesHandler = NotesHandler.loadNoteBook(NotesHandler.defaultFileName);
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
        }
    }
}