package com.example.assignment_2.Repository;
import com.example.assignment_2.Entity.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class OrderRepository {
    public JdbcTemplate jdbc;
    public OrderRepository(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }
    public String GetAll = "SELECT * FROM order";
    public String GetByUser = "SELECT * FROM order WHERE userId=?";
    public String AddOne = "INSERT INTO order (userId, orderDate, totalAmount) VALUES (?, ?, ?)";

    public List<Order> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Order.class));
    }
    public List<Order> getByUserId(int userId) {
        return jdbc.query(GetByUser, new Object[]{userId}, new BeanPropertyRowMapper<>(Order.class));
    }
    public void createOrder(Order order) {
        jdbc.update(AddOne, order.userId, order.orderDate, order.totalAmount);
    }
}
