package com.order.order.controller;

import com.base.base.dto.OrderEventDTO;
import com.order.order.common.OrderResponse;
import com.order.order.dto.OrderDTO;
import com.order.order.kafka.OrderProducer;
import com.order.order.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/api/v1/order"})
@CrossOrigin
public class OrderController {
    private final OrderService orderService;
    private final OrderProducer orderProducer;

    public OrderController(OrderService orderService, OrderProducer orderProducer) {
        this.orderService = orderService;
        this.orderProducer = orderProducer;
    }
    @GetMapping(path = {"/getAll"})
    public List<OrderDTO> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping(path = {"/save"})
    public OrderResponse saveOrder(@RequestBody OrderDTO orderDTO){
        OrderEventDTO orderEventDTO = new OrderEventDTO();
        orderEventDTO.setMessage("Order is commited.");
        orderEventDTO.setStatus("pending");
//        orderProducer.sendMessage(orderEventDTO);

        orderProducer.sendMessage(orderEventDTO);
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
