package py.com.mark.MarNotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.marce.commons.User;
import py.com.mark.MarNotes.Utils.ApiException;
import py.com.mark.MarNotes.Utils.LoginUtils;
import py.com.mark.MarNotes.bean.AccessToken;
import py.com.mark.MarNotes.bean.LoginResult;
import py.com.mark.MarNotes.dao.LoginDAO;
import py.com.mark.MarNotes.dao.UserDAO;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

@Service
public class LoginImpl implements Login{
    @Autowired
    UserDAO userDAO;
    @Autowired
    LoginDAO loginDAO;
    @Override
    public LoginResult userLogin(String document, String password) throws ApiException {
        User user = new User();
        user = userDAO.getUserByDocument(document);

        if( user == null )
            throw new ApiException("Ocurrio un error al consultar la DB");
        if( !user.getPassword().equals(password) )
            throw new ApiException("Credenciales incorrectas");

        AccessToken accessToken = LoginUtils.createAccessToken();

        //registramos el at en la db
        loginDAO.addAccessToken(new Date(),accessToken.getExpiration(),accessToken.getValue());
        LoginResult loginResult =  new LoginResult(accessToken,"Acceso exitoso");



        return loginResult;
    }
}
