package py.com.mark.MarNotes.service;

import py.com.mark.MarNotes.exception.ApiException;
import py.com.mark.MarNotes.bean.Session;

public interface SessionService {
    public Session getSessionFromAccessToken(String accessToken)
            throws ApiException;

    public void invalidateSession(Session session)
            throws ApiException;

    public void log(int sessionId, String tag, String message)
            throws ApiException;


}
