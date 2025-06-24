package com.example.assignment_2.API;
import com.example.assignment_2.Entity.WishLists;
import com.example.assignment_2.Service.WishListsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishListsAPI {
    public final WishListsService wishlistService;
    public WishListsAPI(WishListsService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/{userId}")
    public List<WishLists> getWishlistByUser(@PathVariable int userId) {
        return wishlistService.getWishlistByUserId(userId);
    }

    @PostMapping("/{userId}/add/{productId}")
    public void addToWishlist(@PathVariable int userId, @PathVariable int productId) {
        wishlistService.addProduct(userId, productId);
    }

    @DeleteMapping("/{userId}/remove/{productId}")
    public void removeFromWishlist(@PathVariable int userId, @PathVariable int productId) {
        wishlistService.removeProduct(userId, productId);
    }
}
