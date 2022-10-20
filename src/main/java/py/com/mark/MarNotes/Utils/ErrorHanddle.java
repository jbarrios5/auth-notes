package py.com.mark.MarNotes.Utils;

import py.com.mark.MarNotes.exception.ApiException;

public class ErrorHanddle {

    public static ApiException getSessionExpired(){
        return new ApiException(
                "Session expirada",
                10002
        );
    }
}
