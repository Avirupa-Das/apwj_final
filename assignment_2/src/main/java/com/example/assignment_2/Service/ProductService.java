package com.example.assignment_2.Service;
import com.example.assignment_2.Entity.Product;
import com.example.assignment_2.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    public ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Product getById(int id) {
        return productRepository.getById(id);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    public List<Product> getExpiringSoon() {
        return productRepository.getAll().stream()
                .filter(p -> p.getExpireDate() != null &&
                        !p.getExpireDate().isBefore(LocalDate.now()) &&
                        p.getExpireDate().isBefore(LocalDate.now().plusDays(7)))
                .collect(Collectors.toList());
    }

    public boolean isNearExpire(Product product) {
        return product.getExpireDate() != null &&
                !product.getExpireDate().isBefore(LocalDate.now()) &&
                product.getExpireDate().isBefore(LocalDate.now().plusDays(7));
    }
}
