package com.devcode.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ImmutableAuthorizedResponse;
import org.junit.Test;


public class DevApplicationTests {

    @Test
    public void testConvertJson() throws JsonProcessingException {

        GenericOBj obj = new GenericOBj();
        obj.setFirstName("Gais");
        obj.setLastName("Harch");
        obj.setUserId(1);
        obj.setZipCode(17563);

        System.out.println(" = " + convert(obj));

    }

    private <T> String convert(T input) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(input);
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
        balance+=-10.0;
        System.out.println("negRes = " + balance);
    }

    @Test
    public void concert(){

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

