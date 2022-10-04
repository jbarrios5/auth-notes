package py.com.mark.MarNotes.Utils;

public class ApiException extends java.lang.Exception {
	private int code;
    public ApiException(String message ,int code ) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
