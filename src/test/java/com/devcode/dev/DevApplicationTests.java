package com.devcode.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.AuthorizeRequest;
import model.CancelRequest;
import model.TransferRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import util.JsonConverter;

import java.util.UUID;


public class DevApplicationTests {

    private JsonConverter converter;
    @Before
    public void init(){
        converter = new JsonConverter();
    }

    @Test
    public void testConvertJson() throws JsonProcessingException {

        GenericOBj obj = new GenericOBj();
        obj.setFirstName("Gais");
        obj.setLastName("Harch");
        obj.setUserId(1);
        obj.setZipCode(17563);

        System.out.println(" = " + converter.createResponseEntity(obj, HttpStatus.OK));

    }


    @Test
    public void testMoney() {
        double balance = 100.00;
        String pos = "100.00";
        String neg = "-100.00";
        double posRes = Double.parseDouble(pos);
        double negRes = Double.parseDouble(neg);
        System.out.println("posRes = " + posRes);
        System.out.println("negRes = " + negRes);
        balance += -10.0;
        System.out.println("negRes = " + balance);
    }


    // creating request to use e.g on postman to test application manually
    @Test
    public void concertAuthorizedToJSON() {
        AuthorizeRequest request = new AuthorizeRequest("1",
                "200",
                "SEK",
                "1",
                1,
                "1",
                "1", "1",
                "1",
                new UUID(1,
                        1),
                "gais",
                "1",
                "1",
                "1",
                "1",
                "1",
                null);
        converter.createResponseEntity(request,HttpStatus.OK);
    }

    @Test
    public void concertTransferToJSON() {
        TransferRequest request = new TransferRequest(
                "1",
                "1",
                "200",
                "SEK",
                "",
                "1",
                "1", "1",
                "1",
                "1",
                1,
                "gais",
                "1",
                "1",
                "1",
                "1",
                new UUID(1,
                        1),
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                null);
        converter.createResponseEntity(request,HttpStatus.OK);
    }

    @Test
    public void convertCancelRequestToJson(){
        CancelRequest request = new CancelRequest("1",
                "1",
                "300",
                "SEK",
                "1",
                1,
                "1",
                "1",
                "1",
                new UUID(1,1),
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                null);

        converter.createResponseEntity(request,HttpStatus.OK);
    }

}


class GenericOBj {
    private String firstName;
    private String lastName;
    private int zipCode;
    private int userId;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

