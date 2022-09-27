package py.com.mark.MarNotes.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.marce.commons.Note;
//import py.com.mark.MarNotes.entity.Note;


import java.util.List;

@Repository
public class NoteDAOImpl implements NoteDao{
    private static final String ADD_NOTE= "INSERT INTO notes (description,status,user_id) VALUES (?,?,?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addNote(Note note) {
         jdbcTemplate.update(
                ADD_NOTE,
                note.getDescription(),
                note.getStatus(),
                note.getIdUser()
        );
    }

    @Override
    public List<Note> getAllNotes(String userId) {
        return null;
    }
}
