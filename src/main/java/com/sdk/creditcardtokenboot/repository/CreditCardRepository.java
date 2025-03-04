package com.sdk.creditcardtokenboot.repository;

import com.sdk.creditcardtokenboot.entity.CreditCard;
import com.sdk.creditcardtokenboot.rowmapper.CreditCardRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CreditCardRepository {
    private final JdbcTemplate jdbcTemplate;

    public CreditCardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CreditCard> findAll() {
        return jdbcTemplate.query("SELECT * FROM customer", new CreditCardRowMapper());
    }

    public CreditCard findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id = ?", new CreditCardRowMapper(), id);
    }

    public int save(CreditCard creditCard) {
        return jdbcTemplate.update("INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)",
                customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }

    public int update(CreditCard creditCard) {
        return jdbcTemplate.update("UPDATE customer SET first_name = ?, last_name = ?, email = ? WHERE id = ?",
                customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);
    }

    public void deleteById(int id) {
    }
}

