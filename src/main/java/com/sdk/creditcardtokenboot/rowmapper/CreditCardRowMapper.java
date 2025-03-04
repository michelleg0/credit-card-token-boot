package com.sdk.creditcardtokenboot.rowmapper;

import com.sdk.creditcardtokenboot.entity.CreditCard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CreditCardRowMapper implements RowMapper<CreditCard> {
    @Override
    public CreditCard mapRow(ResultSet rs, int rowNum) throws SQLException {
        CreditCard creditCard = new CreditCard();
        CreditCard.getId(rs.getInt("id"));
        CreditCard.getCredit_card_token(rs.getString("credit card token"));
        CreditCard.getLast_four_cc_digits(rs.getString("last_four_cc_digits"));
        CreditCard.getCustomer_id(rs.getInt("customer_id"));

        return creditCard;
    }
}