package com.devcode.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

}


class GenericOBj{
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

