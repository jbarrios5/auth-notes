package py.com.mark.MarNotes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import py.com.mark.MarNotes.Utils.ApiException;
import py.com.mark.MarNotes.bean.AccessToken;
import py.com.mark.MarNotes.bean.LoginResult;
import py.com.mark.MarNotes.service.Login;

import java.util.Date;
import java.util.UUID;

@RestController
public class AuthAPI {
    Logger log = LoggerFactory.getLogger(AuthAPI.class);
    @Autowired
    Login login;

    @RequestMapping(value = "/auth/{documento}/{pass}",method = RequestMethod.POST)
    public LoginResult login(@PathVariable String documento,@PathVariable String pass) throws ApiException {
        log.info("Starting auth request ...");
        if( documento.isBlank() || pass.isBlank() )
            throw new ApiException("Credenciales incorrectas");

        return login.userLogin(documento,pass);
    }



}
