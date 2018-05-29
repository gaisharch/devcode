package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JsonConverter {

     private   <T> String serializeToJsonFormat(T input) {
        ObjectMapper mapper = new ObjectMapper();
         try {
             return mapper.writeValueAsString(input);
         } catch (JsonProcessingException e) {
             System.out.println("JsonProcessingException" + e);
         }
         return "JsonProcessingException";
     }

    public ResponseEntity<String> createResponseEntity(Object object, HttpStatus status) {
        return new ResponseEntity<>(serializeToJsonFormat(object), status);
    }

}
