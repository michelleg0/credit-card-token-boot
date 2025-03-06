package com.sdk.creditcardtokenboot.repository;

import com.sdk.creditcardtokenboot.entity.CreditCard;
import com.sdk.creditcardtokenboot.rowmapper.CreditCardRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // ✅ This tells Spring to register this class as a Repository Bean
public class CreditCardRepository {
    private final JdbcTemplate jdbcTemplate;

    public CreditCardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CreditCard> findAll() {
        return jdbcTemplate.query("SELECT * FROM credit_card", new CreditCardRowMapper());
    }

    public CreditCard findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM credit_card WHERE id = ?", new CreditCardRowMapper(), id);
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM credit_card WHERE id = ?", id);
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM credit_card WHERE id = ?", id);
    }
}
