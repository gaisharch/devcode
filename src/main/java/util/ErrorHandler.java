package util;

import model.ErrorHandlerObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorHandler {

    private JsonConverter converter;
    public ErrorHandler() {
         converter = new JsonConverter();
    }

    public ResponseEntity<String> getUserNotFound() {
        ErrorHandlerObject errorHandlerObject = new ErrorHandlerObject();
        errorHandlerObject.setCode(HttpStatus.NOT_FOUND.value());
        errorHandlerObject.setMessage(HttpStatus.NOT_FOUND.name());
        return converter.createResponseEntity(errorHandlerObject, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> getUnauthorized() {
        ErrorHandlerObject errorHandlerObject = new ErrorHandlerObject();
        errorHandlerObject.setCode(HttpStatus.UNAUTHORIZED.value());
        errorHandlerObject.setMessage(HttpStatus.UNAUTHORIZED.name());


        return converter.createResponseEntity(errorHandlerObject, HttpStatus.UNAUTHORIZED);
    }
}
