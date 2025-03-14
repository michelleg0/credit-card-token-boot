
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
        creditCard.setCreditCardToken(rs.getString("credit_card_token"));
        creditCard.setLastFourCcDigits(rs.getString("last_four_cc_digits"));
        creditCard.setExpirationMonth(rs.getString("expiration_month"));
        creditCard.setExpirationYear(rs.getString("expiration_year"));
        creditCard.setCustomerId(rs.getInt("customer_id"));
        creditCard.setPaymentProcessorId(rs.getInt("payment_processor_id"));

        return creditCard;
    }
}
