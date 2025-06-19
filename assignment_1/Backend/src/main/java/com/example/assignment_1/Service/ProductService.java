package com.example.assignment_1.Service;

import com.example.assignment_1.Entity.PdtCategory;
import com.example.assignment_1.Entity.Product;
import com.example.assignment_1.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductService {
    public ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product) {
        productRepository.create(product);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Product getById(int ID) {
        return productRepository.get(ID);
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    public List<Product> getExpired() {
        LocalDate today = LocalDate.now();
        return productRepository.getAll().stream()
                .filter( p-> !p.getExpiryDate().isBefore(today) && p.getExpiryDate().isBefore(today.plusDays(7))).collect(Collectors.toList());
    }

    public List<Product> applyDiscount(double discount) {
        List<Product> expiredProduct = getExpired();

        expiredProduct.forEach(p -> p.Price = p.Price *discount);

        return expiredProduct;
    }

    public List<Product> getByCategory(PdtCategory category, double discount) {
        LocalDate today = LocalDate.now();

        return productRepository.getAll().stream()
                .filter(p -> p.getProductCategory() == category)
                .peek(p -> {
                    if (p.getExpiryDate().isBefore(today)) {
                        p.Availablity=false;
                    } else if (p.getExpiryDate().isBefore(today.plusDays(7))) {
                        p.setPrice(p.getPrice() * discount);
                    }
                })
                .collect(Collectors.toList());
    }

    public void createProducts(List<Product> products) {
        productRepository.create(products);
    }


}
