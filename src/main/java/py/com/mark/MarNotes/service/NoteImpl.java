package py.com.mark.MarNotes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.mark.MarNotes.Utils.ApiException;
import py.com.mark.MarNotes.Utils.LoginUtils;
import py.com.mark.MarNotes.bean.AccessToken;
import py.com.mark.MarNotes.dao.LoginDAO;
import py.com.mark.MarNotes.dao.NoteDao;

import java.util.Date;
import java.util.List;

@Service
public class NoteImpl implements Note{
    Logger log = LoggerFactory.getLogger(NoteImpl.class);
    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private NoteDao noteDao;


    @Override
    public void addNote(py.com.marce.commons.Note note, String accessToken) throws ApiException {
        //verificamos si el token aun no expiro
        AccessToken at = loginDAO.getAccessToken(accessToken);

        log.info(String.format("Is token [%s] expiration?",at.getValue()));
        if( LoginUtils.isExpiration(new Date(),at.getExpiration()) )
            throw new ApiException("Token expirado");

        log.info(String.format("Going to add note"));

        noteDao.addNote(note);


    }

    @Override
    public List<py.com.marce.commons.Note> getAllNotes(String userId) {

        return null;
    }
}
