package py.com.mark.MarNotes.service;

import py.com.mark.MarNotes.Utils.ApiException;
import py.com.mark.MarNotes.bean.LoginResult;

public  interface Login {
    public LoginResult userLogin(String document,String password) throws ApiException;

}
