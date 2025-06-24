package com.example.assignment_2.Repository;
import com.example.assignment_2.Entity.OrderItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderItemRepository {
    public JdbcTemplate jdbc;
    public OrderItemRepository(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }
    public String GetByOrder = "SELECT * FROM orderitem WHERE orderId=?";
    public String AddOne = "INSERT INTO orderitems (orderId, productId, productQuantity, price, totalPrice) VALUES (?, ?, ?, ?, ?)";

    public List<OrderItem> getItemsByOrderId(int orderId) {
        return jdbc.query(GetByOrder, new Object[]{orderId}, new BeanPropertyRowMapper<>(OrderItem.class));
    }
    public void addItem(OrderItem item) {
        jdbc.update(AddOne, item.orderId, item.productId, item.productQuantity, item.price);
    }
    public List<OrderItem> getAll() {
        return jdbc.query("SELECT * FROM order_items", new BeanPropertyRowMapper<>(OrderItem.class));
    }

}
