package com.example.assignment_2.Repository;
import com.example.assignment_2.Entity.Invoice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class InvoiceRepository {
    private final JdbcTemplate jdbc;
    public InvoiceRepository(DataSource dataSource)
    {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    private final String GetAll = "SELECT * FROM invoice";
    private final String GetByUser = "SELECT i.* FROM invoice i JOIN orders o ON i.orderId = o.id WHERE o.userId = ?";
    private final String AddOne = "INSERT INTO invoice (orderId, invoDate, totalAmount, discount, finalAmount) VALUES (?, ?, ?, ?, ?)";

    public List<Invoice> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Invoice.class));
    }
    public List<Invoice> getByUserId(int userId)
    {
        return jdbc.query(GetByUser, new Object[]{userId}, new BeanPropertyRowMapper<>(Invoice.class));
    }
    public void generateInvoice(Invoice invoice) {
        jdbc.update(AddOne,
                invoice.orderId,
                invoice.invoDate,
                invoice.totalAmount,
                invoice.discount,
                invoice.finalAmount
        );
    }
}
