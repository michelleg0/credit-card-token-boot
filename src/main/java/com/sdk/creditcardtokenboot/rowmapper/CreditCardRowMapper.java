
package com.sdk.creditcardtokenboot.rowmapper;

import com.sdk.creditcardtokenboot.entity.CreditCard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


//this is the class that parses the result set object into credit card object data

public class CreditCardRowMapper implements RowMapper<CreditCard> {
    @Override
    public CreditCard mapRow(ResultSet rs, int rowNum) throws SQLException {
        CreditCard creditCard = new CreditCard();
        creditCard.setId(rs.getInt("id"));
        creditCard.setCredit_card_token(rs.getString("credit_card_token")); // Ensure column name matches DB
        creditCard.setLast_four_cc_digits(rs.getString("last_four_cc_digits"));
        creditCard.setCustomer_id(rs.getInt("customer_id"));
        creditCard.setExpiration_month(rs.getString("expiration_month"));
        creditCard.setExpiration_year(rs.getString("expiration_year"));
        creditCard.setPayment_processor_id(rs.getInt("payment_processor_id"));

        return creditCard;
    }
}
