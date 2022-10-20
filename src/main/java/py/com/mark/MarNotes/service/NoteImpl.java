package py.com.mark.MarNotes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.mark.MarNotes.exception.ApiException;
import py.com.mark.MarNotes.Utils.ErrorHanddle;
import py.com.mark.MarNotes.Utils.LoginUtils;
import py.com.mark.MarNotes.bean.Session;
import py.com.mark.MarNotes.dao.LoginDAO;
import py.com.mark.MarNotes.dao.NoteDao;

import java.util.List;

@Service
public class NoteImpl implements Note{
    Logger log = LoggerFactory.getLogger(NoteImpl.class);
    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private NoteDao noteDao;


    @Override
    public void addNote(py.com.marce.commons.Note note, Session session) throws ApiException {
        //verificamos si el token aun no expiro
        //AccessToken at = loginDAO.getAccessToken(accessToken);

        log.info(String.format("Is session [%s] expiration?",session.getAccessToken()));
        if( LoginUtils.isExpiration(session.getExpires()) )
            throw ErrorHanddle.getSessionExpired();

        log.info(String.format("We've recived: [%s] ",note.toString()));
        if( note == null )throw new ApiException("Bad request",LoginUtils.BAD_REQUEST);

        note.setIdUser(session.getSessionId());
        noteDao.addNote(note);


    }

    @Override
    public List<py.com.marce.commons.Note> getAllNotes(Integer userId) {

        return noteDao.getAllNotes(userId);
    }
}
