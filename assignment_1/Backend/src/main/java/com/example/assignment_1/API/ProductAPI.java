package com.example.assignment_1.API;

import com.example.assignment_1.Entity.PdtCategory;
import com.example.assignment_1.Entity.Product;
import com.example.assignment_1.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductAPI {
    public ProductService productService;

    public ProductAPI(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return "Product added successfully";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/Product/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") int id) {
        return productService.getById(id);
    }

    @PostMapping("/update")
    public String updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return "Product updated successfully";
    }

    @GetMapping("/expiring")
    @ResponseBody
    public List<Product> applyDiscount() {
        return productService.getExpired();
    }

    @PostMapping("/apply/{discount}")
    public String applyDiscounts(@RequestParam double discount) {
        productService.applyDiscount(discount);
        return "Discounts applied.";
    }

    @GetMapping("/category-discount")
    @ResponseBody
    public List<Product> getByCategory(
            @RequestParam PdtCategory category,
            @RequestParam double discount
    ) {
        return productService.getByCategory(category, discount);
    }

    @PostMapping("/add-bulk")
    public String createProducts(@RequestBody List<Product> products) {
        productService.createProducts(products);
        return "Bulk products added successfully";
    }

}
