package com.example.assignment_2.Service;

import com.example.assignment_2.Entity.Cart;
import com.example.assignment_2.Entity.CartItem;
import com.example.assignment_2.Repository.CartItemRepository;
import com.example.assignment_2.Repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService {
    public CartRepository cartRepository;
    public CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }
    public Cart getCartByUserId(int userId) {
        return cartRepository.getCartByUserId(userId);
    }

    public void createCart(int userId) {
        cartRepository.createCart(userId);
    }

    public List<CartItem> getItems(int cartId) {
        return cartItemRepository.getByCartId(cartId);
    }

    public void addItem(CartItem item) {
        cartItemRepository.addCartItem(item);
    }

    public void updateQuantity(int itemId, int quantity) {
        cartItemRepository.updateQuantity(itemId, quantity);
    }

    public void removeItem(int itemId) {
        cartItemRepository.removeCartItem(itemId);
    }
}
