package py.com.mark.MarNotes.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.marce.commons.Note;
import py.com.mark.MarNotes.Utils.NotesMapper;
//import py.com.mark.MarNotes.entity.Note;


import java.util.List;

@Repository
public class NoteDAOImpl implements NoteDao{
    private static final String ADD_NOTE = "INSERT INTO notes (description,status,user_id) VALUES (?,?,?)";
    private static final String GET_NOTES = "SELECT * FROM notes WHERE user_id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addNote(Note note) {
        try {
            jdbcTemplate.update(
                    ADD_NOTE,
                    note.getDescription(),
                    note.getStatus(),
                    note.getIdUser()
            );

        }catch (Exception e){
            System.out.println("Error en la base de datos"+e);
        }
    }

    @Override
    public List<Note> getAllNotes(Integer userId) {
        List<Note> notes = null;
        try {
            notes = jdbcTemplate.query(GET_NOTES,new NotesMapper(),new Object[] {userId});

        }catch (Exception e){
            System.out.println(""+e);
        }
        return notes;
    }
}
