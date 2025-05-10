package com.order.order.controller;

import com.order.order.common.OrderResponse;
import com.order.order.dto.OrderDTO;
import com.order.order.services.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping(path = {"/api/v1/order"})
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping(path = {"/getAll"})
    public List<OrderDTO> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping(path = {"/save"})
    public OrderResponse saveOrder(@RequestBody OrderDTO orderDTO){
//        Integer itemId = orderDTO.getItemId();
        return orderService.saveOrder(orderDTO);
    }

    @PutMapping(path = {"/update-order"})
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping(path = {"/delete-order/{id}"})
    public String deleteOrder(@RequestBody OrderDTO orderDTO, @PathVariable int id){
        return orderService.deleteOrder(orderDTO,id);
    }

    @GetMapping(path = {"/get-order-by-id/{orderId}"})
    public OrderDTO getOrderById(@PathVariable int orderId){
        return orderService.getOrdersByOrderId(orderId);
    }
}
