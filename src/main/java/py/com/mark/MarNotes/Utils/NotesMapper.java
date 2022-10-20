package py.com.mark.MarNotes.Utils;

import org.springframework.jdbc.core.RowMapper;
import py.com.marce.commons.Note;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotesMapper implements RowMapper<Note> {
    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
        Note  note = new Note();
        note.setId(rs.getInt("id"));
        note.setIdUser(rs.getInt("user_id"));
        note.setDescription(rs.getString("description"));
        note.setStatus(rs.getBoolean("status"));
        return note;
    }
}
