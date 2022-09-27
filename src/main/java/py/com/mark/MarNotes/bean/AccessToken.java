package py.com.mark.MarNotes.bean;

import java.util.Date;

public class AccessToken {
    private String value;



    private Date expiration;


    public AccessToken() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }


}
