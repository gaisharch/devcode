package model;

public class DevCodeUserCustomer {

    private String userId;
    private boolean success;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private String country;
    private String email;
    private String dob;
    private String mobile;
    private Number balance;
    private String balanceCy;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Number getBalance() {
        return balance;
    }

    public void setBalance(Number balance) {
        this.balance = balance;
    }

    public String getBalanceCy() {
        return balanceCy;
    }

    public void setBalanceCy(String balanceCy) {
        this.balanceCy = balanceCy;
    }
}
