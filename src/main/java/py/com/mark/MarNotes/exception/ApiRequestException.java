package py.com.mark.MarNotes.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException  {
    private int code;
    private  String message;
    private HttpStatus httpStatus;

    public ApiRequestException() {
    }

    public ApiRequestException(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
