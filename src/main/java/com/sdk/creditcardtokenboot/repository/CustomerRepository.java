package com.sdk.creditcardtokenboot.repository;

import com.sdk.creditcardtokenboot.entity.Customer;
import com.sdk.creditcardtokenboot.rowmapper.CustomerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM customer", new CustomerRowMapper());
    }

    public Customer findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id = ?", new CustomerRowMapper(), id);
    }

    public int save(Customer customer) {
        return jdbcTemplate.update("INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)",
                customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }

    public int update(Customer customer) {
        return jdbcTemplate.update("UPDATE customer SET first_name = ?, last_name = ?, email = ? WHERE id = ?",
                customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);
    }
}
