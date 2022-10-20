package py.com.mark.MarNotes.bean;

import java.sql.Timestamp;
import java.util.Date;

public class AccessToken {
    private String value;



    private Timestamp expiration;


    public AccessToken() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getExpiration() {
        return expiration;
    }

    public void setExpiration(Timestamp expiration) {
        this.expiration = expiration;
    }


}
