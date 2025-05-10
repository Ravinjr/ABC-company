package com.order.order.services.impl;

import com.inventory.inventory.dto.InventoryDTO;
import com.inventory.inventory.model.Inventory;
import com.order.order.common.ErrorOrderResponse;
import com.order.order.common.OrderResponse;
import com.order.order.common.SuccessOrderResponse;
import com.order.order.dto.OrderDTO;
import com.order.order.model.Orders;
import com.order.order.repository.OrderRepository;
import com.order.order.services.OrderService;
import com.product.product.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Service
public class OrderServiceIMPL implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final WebClient productWebClient;
    private final WebClient inventoryWebClient;

    public OrderServiceIMPL(OrderRepository orderRepository, ModelMapper modelMapper, WebClient productWebClient, WebClient inventoryWebClient) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.productWebClient = productWebClient;
        this.inventoryWebClient = inventoryWebClient;
    }

    @Override
    public List<OrderDTO> getOrders() {
        List<Orders> orders = orderRepository.findAll();
        return modelMapper.map(orders, new TypeToken<List<OrderDTO>>() {}.getType());
    }

    @Override
    public OrderResponse saveOrder(OrderDTO orderDTO) {
        Integer itemId = orderDTO.getItemId();
        try{
            InventoryDTO inventoryResponse = inventoryWebClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/get-item-by-item-id/{itemId}").build(itemId))
                    .retrieve()
//                    mention return type by body to mono
                    .bodyToMono(InventoryDTO.class)
                    .block();

            assert inventoryResponse != null;

           Integer productId = inventoryResponse.getProductId();

            ProductDTO productResponse = productWebClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/get-product-by-product-id/{productId}").build(productId))
                    .retrieve()
//                    mention return type by body to mono
                    .bodyToMono(ProductDTO.class)
                    .block();

            assert productResponse != null;
            if(inventoryResponse.getQuantity() > 0){
                if(productResponse.getForSale() == 1){
                    orderRepository.save(modelMapper.map(orderDTO, Orders.class));
                }else {
                    return new ErrorOrderResponse("This item is not for sale.");
                }
                return new SuccessOrderResponse(orderDTO);
            }else{
                return new ErrorOrderResponse("Item not available,Please try later.");
            }
        } catch (WebClientResponseException e) {
            if(e.getStatusCode().is5xxServerError()){
                return new ErrorOrderResponse("Item not found.");
            }
        }
        return null;

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
