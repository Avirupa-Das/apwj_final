package com.example.assignment_2.Service;
import com.example.assignment_2.Entity.Order;
import com.example.assignment_2.Entity.OrderItem;
import com.example.assignment_2.Entity.Product;
import com.example.assignment_2.Repository.OrderItemRepository;
import com.example.assignment_2.Repository.OrderRepository;
import com.example.assignment_2.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {
    public OrderRepository orderRepository;
    public OrderItemRepository orderItemRepository;
    public ProductRepository productRepository;

    public ReportService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    public Map<String, Double> getSalesPerCategory() {
        List<Product> products = productRepository.getAll();
        List<OrderItem> items = orderItemRepository.getAll();

        Map<String, Double> sales = new HashMap<>();

        for (OrderItem item : items) {
            Product product = products.stream()
                    .filter(p -> p.getId() == item.getProductId())
                    .findFirst().orElse(null);

            if (product != null) {
                String category = product.getCategory().toString();
                double total = item.getTotalPrice() * item.getProductQuantity();
                sales.put(category, sales.getOrDefault(category, 0.0) + total);
            }
        }
        return sales;
    }

    public double getTotalRevenue() {
        List<Order> orders = orderRepository.getAll();
        return orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }

    public int getTotalOrderCount() {
        return orderRepository.getAll().size();
    }

    public List<Map.Entry<String, Integer>> getBestSellingProducts(int topN) {
        List<OrderItem> items = orderItemRepository.getAll();
        List<Product> products = productRepository.getAll();

        Map<Integer, Integer> quantitySoldMap = new HashMap<>();
        for (OrderItem item : items) {
            quantitySoldMap.put(
                    item.getProductId(),
                    quantitySoldMap.getOrDefault(item.getProductId(), 0) + item.getProductQuantity()
            );
        }

        Map<String, Integer> bestSellers = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : quantitySoldMap.entrySet()) {
            int productId = entry.getKey();
            Product product = products.stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst().orElse(null);

            if (product != null) {
                bestSellers.put(product.getName(), entry.getValue());
            }
        }
        return bestSellers.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topN)
                .collect(Collectors.toList());
    }
}
