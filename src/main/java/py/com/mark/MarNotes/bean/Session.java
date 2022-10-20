package py.com.mark.MarNotes.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Session {
    private Integer sessionId;
    private String accessToken;
    private Timestamp expires;

    public Session() {
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Timestamp getExpires() {
        return expires;
    }

    public void setExpires(Timestamp expires) {
        this.expires = expires;
    }

}
