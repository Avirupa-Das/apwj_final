package com.example.assignment_2.Repository;
import com.example.assignment_2.Entity.CartItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CartItemRepository {
    public final JdbcTemplate jdbc;

    public CartItemRepository(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public String GetAllByCartId = "SELECT * FROM cartitem WHERE cartId=?";
    public String AddOne = "INSERT INTO cartitem (cartId, productId, quantity) VALUES (?, ?, ?)";
    public String UpdateQuantity = "UPDATE cartitem SET quantity=? WHERE id=?";
    public String DeleteOne = "DELETE FROM cartitem WHERE id=?";

    public List<CartItem> getByCartId(int cartId) {
        return jdbc.query(GetAllByCartId, new Object[]{cartId}, new BeanPropertyRowMapper<>(CartItem.class));
    }
    public void addCartItem(CartItem item) {
        jdbc.update(AddOne, item.getCartId(), item.getProductId(), item.getQuantity());
    }
    public void updateQuantity(int id, int quantity) {
        jdbc.update(UpdateQuantity, quantity, id);
    }
    public void removeCartItem(int id) {
        jdbc.update(DeleteOne, id);
    }

}
