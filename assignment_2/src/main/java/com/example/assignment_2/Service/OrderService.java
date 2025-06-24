package com.example.assignment_2.Service;
import com.example.assignment_2.Entity.Order;
import com.example.assignment_2.Entity.OrderItem;
import com.example.assignment_2.Repository.OrderItemRepository;
import com.example.assignment_2.Repository.OrderItemRepository;
import com.example.assignment_2.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public OrderRepository orderRepository;
    public OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }
    public List<Order> getAllOrders() {
        return orderRepository.getAll();
    }

    public List<Order> getByUserId(int userId) {
        return orderRepository.getByUserId(userId);
    }

    public void createOrder(Order order) {
        orderRepository.createOrder(order);
    }

    public void addOrderItem(OrderItem item) {
        orderItemRepository.addItem(item);
    }

    public List<OrderItem> getItemsByOrderId(int orderId) {
        return orderItemRepository.getItemsByOrderId(orderId);
    }

}
