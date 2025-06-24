package com.example.assignment_2.Repository;
import com.example.assignment_2.Entity.Cart;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class CartRepository {
    public final JdbcTemplate jdbc;
    public CartRepository(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }
    public String CartCreated = "INSERT INTO cart (userId) VALUES (?)";
    public String GetCartByTheUser = "SELECT * FROM cart WHERE userId=?";
    public Cart getCartByUserId(int userId) {
        List<Cart> carts = jdbc.query(GetCartByTheUser,new Object[]{userId},new BeanPropertyRowMapper<>(Cart.class));
        return carts.isEmpty() ? null : carts.get(0);
    }
    public void createCart(int userId) {
        jdbc.update(CartCreated, userId);
    }
}
