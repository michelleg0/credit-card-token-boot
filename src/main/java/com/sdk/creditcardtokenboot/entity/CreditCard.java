package com.sdk.creditcardtokenboot.entity;


public class CreditCard {
    private int id;
    private static String credit_card_token;
    private static String last_four_cc_digits;
    private String expiration_month;
    private String expiration_year;
    private static int customer_id;
    private int payment_processor_id;

    public CreditCard() {
    }

    public CreditCard(int id, String last_four_cc_digits, String credit_card_token, String expiration_month, String expiration_year, int customer_id, int payment_processor_id) {
        this.id = id;
        this.last_four_cc_digits = last_four_cc_digits;
        this.credit_card_token = credit_card_token;
        this.expiration_month = expiration_month;
        this.expiration_year = expiration_year;
        this.customer_id = customer_id;
        this.payment_processor_id = payment_processor_id;
    }

    public static int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getLast_four_cc_digits(String lastFourCcDigits) {
        return last_four_cc_digits;
    }

    public void setLast_four_cc_digits(String last_four_cc_digits) {
        this.last_four_cc_digits = last_four_cc_digits;
    }

    public static String getCredit_card_token(String creditCardToken) {
        return credit_card_token;
    }

    public void setCredit_card_token(String credit_card_token) {
        this.credit_card_token = credit_card_token;
    }

    public String getExpiration_month() {
        return expiration_month;
    }

    public void setExpiration_month(String expiration_month) {
        this.expiration_month = expiration_month;
    }

    public void setExpiration_year(String expiration_year) {
        this.expiration_month = expiration_month;
    }

    public String getExpiration_year() {
        return expiration_year;
    }


    public static int getCustomer_id(int customerId) {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getPayment_processor_id() {
        return payment_processor_id;
    }

    public void setPayment_processor_id(int payment_processor_id) {
        this.payment_processor_id = payment_processor_id;
    }
}


