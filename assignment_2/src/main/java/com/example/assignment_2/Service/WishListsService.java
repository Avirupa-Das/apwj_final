package com.example.assignment_2.Service;
import com.example.assignment_2.Entity.WishLists;
import com.example.assignment_2.Repository.WishListsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListsService {
    public WishListsRepository wishListsRepository;

    public WishListsService(WishListsRepository wishListsRepository) {
        this.wishListsRepository = wishListsRepository;
    }
    public List<WishLists> getWishlistByUserId(int userId) {
        return wishListsRepository.getWishlistByUserId(userId);
    }

    public void addProduct(int userId, int productId) {
        wishListsRepository.addProductToWishlist(userId, productId);
    }

    public void removeProduct(int userId, int productId) {
        wishListsRepository.removeProductFromWishlist(userId, productId);
    }
}
