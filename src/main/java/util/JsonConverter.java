package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonConverter {

     public  <T> String serializeToJsonFormat(T input) {
        ObjectMapper mapper = new ObjectMapper();
         try {
             return mapper.writeValueAsString(input);
         } catch (JsonProcessingException e) {
             System.out.println("JsonProcessingException" + e);
         }
         return "JsonProcessingException";
     }



}
