package py.com.mark.MarNotes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.mark.MarNotes.exception.ApiException;
import py.com.mark.MarNotes.Utils.LoginUtils;
import py.com.mark.MarNotes.bean.LoginResult;
import py.com.mark.MarNotes.service.Login;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("auth")
public class AuthAPI {
    Logger log = LoggerFactory.getLogger(AuthAPI.class);
    @Autowired
    Login login;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public LoginResult login(@RequestParam(value = "documento",required = true) String documento,
                             @RequestParam(value = "password",required = true) String pass,
                             HttpServletRequest request
    ) throws ApiException {
        log.info("Starting auth request ...");
        if( documento.isBlank() || pass.isBlank() )
            throw new ApiException("Credenciales incorrectas", LoginUtils.NOT_ACCESS);

        return login.userLogin(documento,pass);
    }
    @RequestMapping(value = "/change_password",method = RequestMethod.PUT)
    public void changePassword(
            @RequestParam(value = "document",required = true) String document,
            @RequestParam(value = "password",required = true)String password
    ){
        log.info("Starting the request to change the password");
        login.changePassword(document,password);
    }



}
