package com.sdk.creditcardtokenboot.repository;

import com.sdk.creditcardtokenboot.entity.Customer;
import com.sdk.creditcardtokenboot.rowmapper.CustomerRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

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

    public Integer getCustomerId(int customerId) {
        String sql = "SELECT id FROM customer WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class, customerId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public String getCustomerEmail(int customerId) {
        String sql = "SELECT email FROM customer WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, customerId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public List<Map<String, Object>> findCustomersForExport() {
        String sql = """
        SELECT c.id, c.first_name, c.last_name, 
               GROUP_CONCAT(DISTINCT cc.credit_card_token ORDER BY cc.id SEPARATOR ', ') AS credit_card_tokens
        FROM customer c
        LEFT JOIN credit_card cc ON c.id = cc.customer_id
        GROUP BY c.id, c.first_name, c.last_name
    """;
        return jdbcTemplate.queryForList(sql);
    }

}
