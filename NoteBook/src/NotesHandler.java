import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class NotesHandler implements Serializable {
    public static String defaultFileName = "notes.db";
    private final ArrayList<Note> notes = new ArrayList<>();
    public void addNote(String name, String contents) throws Exception {
        if(getNoteByName(name)!=null){
            throw new Exception("Name is already in notes");
        }
        notes.add(new Note(name, contents));
        update();
    }
    public void removeNote(int index) throws IOException {
        notes.remove(index);
        update();
    }
    public Note getNote(int index) throws  IndexOutOfBoundsException{
        if(index<0 || index>=notes.size())
            throw new IndexOutOfBoundsException();
        return notes.get(index);
    }
    public Note getNoteByName(String name){
        for(Note note : notes){
            if(note.getName().equals(name)){
                return note;
            }
        }
        return null;
    }
    public void removeNote(String name) throws IOException {
        notes.removeIf(note -> note.getName().equals(name));
        update();
    }
    public ArrayList<Note> getNotes(){return notes;}

    public static void saveNoteBook(NotesHandler noteBook,String fileName) throws IOException {
        FileOutputStream fout = null;
        ObjectOutputStream oOut = null;
        fout = new FileOutputStream(fileName);
        oOut = new ObjectOutputStream(fout);
        oOut.writeObject(noteBook);
        oOut.close();
        fout.close();
    }
    public static NotesHandler loadNoteBook(String filename) throws IOException,ClassNotFoundException {
        NotesHandler result = null;
        FileInputStream fin = null;
        fin = new FileInputStream(filename);
        ObjectInputStream oIn = new ObjectInputStream(fin);
        result = (NotesHandler)oIn.readObject();
        oIn.close();
        fin.close();
        return result;
    }
    public void update() throws IOException {
        saveNoteBook(this, defaultFileName);
    }
}
