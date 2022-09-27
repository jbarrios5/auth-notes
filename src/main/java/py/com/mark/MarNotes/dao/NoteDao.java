package py.com.mark.MarNotes.dao;

//import py.com.mark.MarNotes.entity.Note;

import py.com.marce.commons.Note;

import java.util.List;

public interface NoteDao {
    public void addNote(Note note);
    public List<Note> getAllNotes(String  userId);

}
