package com.sdk.creditcardtokenboot.entity;

public class CreditCard {
    private int id;
    private String creditCardToken;
    private String lastFourCcDigits;
    private String expirationMonth;
    private String expirationYear;
    private int customerId;
    private int paymentProcessorId;

    // Default Constructor
    public CreditCard() {
    }

    // Constructor with parameters
    public CreditCard(int id, String creditCardToken, String lastFourCcDigits, String expirationMonth, String expirationYear, int customerId, int paymentProcessorId) {
        this.id = id;
        this.creditCardToken = creditCardToken;
        this.lastFourCcDigits = lastFourCcDigits;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.customerId = customerId;
        this.paymentProcessorId = paymentProcessorId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreditCardToken() {
        return creditCardToken;
    }

    public void setCreditCardToken(String creditCardToken) {
        this.creditCardToken = creditCardToken;
    }

    public String getLastFourCcDigits() {
        return lastFourCcDigits;
    }

    public void setLastFourCcDigits(String lastFourCcDigits) {
        this.lastFourCcDigits = lastFourCcDigits;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPaymentProcessorId() {
        return paymentProcessorId;
    }

    public void setPaymentProcessorId(int paymentProcessorId) {
        this.paymentProcessorId = paymentProcessorId;
    }

    public void setCredit_card_token(String credit_card_token) {
    }

    public void setLast_four_cc_digits(String lastFourCcDigits) {
    }

    public void setCustomer_id(int customer_id) {
    }

    public void setExpiration_month(String expiration_month) {
    }

    public void setExpiration_year(String expiration_year) {
    }

    public void setPayment_processor_id(int paymentProcessorId) {
    }
}
