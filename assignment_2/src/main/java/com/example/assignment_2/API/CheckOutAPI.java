package com.example.assignment_2.API;
import com.example.assignment_2.Entity.Invoice;
import com.example.assignment_2.Service.CheckOutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckOutAPI {
    public CheckOutService checkoutService;

    public CheckOutAPI(CheckOutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/{userId}")
    public Invoice checkout(@PathVariable int userId,
                            @RequestParam(defaultValue = "20") double discountRatePercent) {
        return checkoutService.checkout(userId, discountRatePercent);
    }
}
