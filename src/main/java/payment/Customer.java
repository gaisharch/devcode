package payment;

import model.DevCodeUserCustomer;

public class Customer {

    public static DevCodeUserCustomer create() {
        DevCodeUserCustomer customer = new DevCodeUserCustomer();
        customer.setUserId("1");
        customer.setSuccess(true);
        customer.setFirstName("Gais");
        customer.setLastName("Harch");
        customer.setStreet("Evenemangsgatan 30");
        customer.setCity("Stockholm");
        customer.setZip("16956");
        customer.setCountry("Sweden");
        customer.setEmail("gais@kth.se");
        customer.setDob("1990-04-23");
        customer.setMobile("+46700874629");
        customer.setBalance(1000000.00);
        customer.setBalanceCy("SEK");
        return customer;
    }
}
