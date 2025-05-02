package com.order.order.services;

import com.order.order.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<OrderDTO> getOrders();

    OrderDTO saveOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(OrderDTO orderDTO);

    String deleteOrder(OrderDTO orderDTO, int id);

    OrderDTO getOrderById(int id);
}
