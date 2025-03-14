package com.sdk.creditcardtokenboot.repository;

import com.sdk.creditcardtokenboot.entity.CustomerExport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerExportRepository {
    private final JdbcTemplate jdbcTemplate;

    public CustomerExportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CustomerExport> exportCustomers() {

        String sql = """
            SELECT c.id, c.first_name, c.last_name, cc.credit_card_token
            FROM customer c
            LEFT JOIN credit_card cc ON c.id = ct.customer_id
        """;

        RowMapper<CustomerExport> rowMapper = (rs, rowNum) ->
                new CustomerExport(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("credit_card_token")
                );

        return jdbcTemplate.query(sql, rowMapper);
    }
}
