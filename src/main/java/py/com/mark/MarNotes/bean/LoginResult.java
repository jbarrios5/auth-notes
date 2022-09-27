package py.com.mark.MarNotes.bean;

public class LoginResult {
    private AccessToken at;
    private String message;
    public LoginResult(AccessToken at,String message) {
        this.at = at;
        this.message = message;
    }

    public LoginResult() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AccessToken getAt() {
        return at;
    }

    public void setAt(AccessToken at) {
        this.at = at;
    }
}
