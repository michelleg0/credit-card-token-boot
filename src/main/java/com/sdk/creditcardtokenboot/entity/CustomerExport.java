package com.sdk.creditcardtokenboot.entity;

public class CustomerExport {
    private int id;
    private String firstName;
    private String lastName;
    private String creditCardToken;

    // Constructor
    public CustomerExport(int id, String firstName, String lastName, String creditCardToken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCardToken = creditCardToken;
    }

    // Getters
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCreditCardToken() { return creditCardToken; }
}
