package py.com.mark.MarNotes.service;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.mark.MarNotes.Utils.ErrorHanddle;
import py.com.mark.MarNotes.exception.ApiException;
import py.com.mark.MarNotes.Utils.LoginUtils;
import py.com.mark.MarNotes.bean.Session;
import py.com.mark.MarNotes.dao.SessionDAO;
@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionDAO sessionDAO;
    @Override
    public Session getSessionFromAccessToken(String accessToken) throws ApiException {
        //todo make formatter to at
        //We find session in db
        Session session = sessionDAO.findByAccessToken(accessToken);
        if( session == null ) throw new ApiException("Session no ecnontrada",LoginUtils.SESSION_NOT_FOUND);


        invalidateSession(session);
        return session;
    }

    @Override
    public void invalidateSession(Session session) throws ApiException {

        if( LoginUtils.isExpiration(session.getExpires()) )throw ErrorHanddle.getSessionExpired();

    }

    @Override
    public void log(int sessionId, String tag, String message) throws ApiException {

    }
}
