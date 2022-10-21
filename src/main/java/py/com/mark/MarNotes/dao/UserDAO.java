package py.com.mark.MarNotes.dao;


import py.com.marce.commons.User;

public interface UserDAO {
    public User getUserByDocument(String document);
    public void changePassword(User user);
}
