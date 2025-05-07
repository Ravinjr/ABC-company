package com.order.order.services.impl;

import com.order.order.dto.OrderDTO;
import com.order.order.model.Orders;
import com.order.order.repository.OrderRepository;
import com.order.order.services.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OrderServiceIMPL implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final WebClient webClient;

    public OrderServiceIMPL(OrderRepository orderRepository, ModelMapper modelMapper, WebClient webClient) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.webClient = webClient;
    }

    @Override
    public List<OrderDTO> getOrders() {
        List<Orders> orders = orderRepository.findAll();
        return modelMapper.map(orders, new TypeToken<List<OrderDTO>>() {}.getType());
    }

    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
       orderRepository.save(modelMapper.map(orderDTO, Orders.class));
       return orderDTO;
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        orderRepository.save(modelMapper.map(orderDTO, Orders.class));
        return orderDTO;
    }

    @Override
    public String deleteOrder(OrderDTO orderDTO, int id) {
        orderRepository.deleteById(id);
        return "Order deleted";
    }

    @Override
    public OrderDTO getOrdersByOrderId(int orderId) {
        Orders order = orderRepository.getOrdersByOrderId(orderId);
        return modelMapper.map(order, OrderDTO.class);
    }


}
