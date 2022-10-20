package py.com.mark.MarNotes.dao;

import py.com.marce.commons.User;
import py.com.mark.MarNotes.bean.AccessToken;
import py.com.mark.MarNotes.bean.Session;

import java.sql.Timestamp;

public interface SessionDAO {
    public Session createSession (User user, AccessToken at , Timestamp expires);
    public Session findByAccessToken(String at);
}
