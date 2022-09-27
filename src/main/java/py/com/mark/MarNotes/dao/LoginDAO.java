package py.com.mark.MarNotes.dao;

import py.com.mark.MarNotes.bean.AccessToken;

import java.util.Date;

public interface LoginDAO {
    public void addAccessToken(Date created, Date expiration, String at);
    public AccessToken getAccessToken(String at);
}
