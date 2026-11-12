package com.example.Medical_store.Service;

import com.example.Medical_store.Dto.OrderDto;
import com.example.Medical_store.Exception.OrderNotFoundException;
import com.example.Medical_store.Repository.OrderRepository;
import com.example.Medical_store.Entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(OrderDto dto) {

        Order order = Order.builder()
                .totalAmount(dto.getTotalAmount())
                .status(dto.getStatus())
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order not found with id : " + id));
    }

    public void deleteOrder(Long id) {

        Order order = getOrderById(id);

        orderRepository.delete(order);
    }
}
