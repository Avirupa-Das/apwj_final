package com.example.assignment_2.API;
import com.example.assignment_2.Entity.Product;
import com.example.assignment_2.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductAPI {
    public ProductService productService;
    public ProductAPI(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getById(id);
    }
    @GetMapping("/expiring-soon")
    public List<Product> getExpiringProducts() {
        return productService.getExpiringSoon();
    }
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}

