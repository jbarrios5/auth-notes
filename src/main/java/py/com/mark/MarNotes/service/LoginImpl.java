package py.com.mark.MarNotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.marce.commons.User;
import py.com.mark.MarNotes.exception.ApiException;
import py.com.mark.MarNotes.Utils.LoginUtils;
import py.com.mark.MarNotes.bean.AccessToken;
import py.com.mark.MarNotes.bean.LoginResult;
import py.com.mark.MarNotes.bean.Session;
import py.com.mark.MarNotes.dao.LoginDAO;
import py.com.mark.MarNotes.dao.SessionDAO;
import py.com.mark.MarNotes.dao.UserDAO;

@Service
public class LoginImpl implements Login{

    @Autowired
    SessionDAO sessionDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    LoginDAO loginDAO;
    @Override
    public LoginResult userLogin(String document, String password) throws ApiException {

        User user = userDAO.getUserByDocument(document);
        if( user == null )
            throw new ApiException("Erro al hacer login",LoginUtils.NOT_ACCESS);
        if( !user.getPassword().equals(password) )
            throw new ApiException("Credenciales incorrectas",LoginUtils.NOT_ACCESS);

        //todo: create a new service to access toke
        // add new property to access token ,because It not saving user id
        AccessToken accessToken = LoginUtils.createAccessToken();

        Session session = sessionDAO.createSession(user,accessToken,accessToken.getExpiration());
        //registramos el at en la db
        //loginDAO.addAccessToken(new Date(),accessToken.getExpiration(),accessToken.getValue());

        return new LoginResult(accessToken,"Acceso exitoso");



    }
}
