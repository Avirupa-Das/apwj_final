package com.example.assignment_1.Repository;

import com.example.assignment_1.Entity.PdtCategory;
import com.example.assignment_1.Entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public static List<Product> products= new ArrayList<>();
    static {
     products.add(new Product(1,"Cucumber",60.00,2, LocalDate.of(2025,6,22), PdtCategory.Vegetables));
     products.add(new Product(2,"Salt",40.00,1, LocalDate.of(2025,6,20), PdtCategory.Groceries));
     products.add(new Product(3,"Serum",1500,1, LocalDate.of(2025,6,24), PdtCategory.BeautyCare));
    }

    public void create(Product product) {products.add(product);}

    public void create(List<Product> productList) {
        products.addAll(productList);
    }

    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    public Product get(int ID) {
        return products.stream()
                .filter(s -> s.getID() == ID)
                .findFirst()
                .orElse(null);
    }
    public boolean update(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product existing = products.get(i);
            if (existing.getID() == updatedProduct.getID()) {
                products.set(i, updatedProduct);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int ID) {
        return products.removeIf(s -> s.getID() == ID);
    }

}
