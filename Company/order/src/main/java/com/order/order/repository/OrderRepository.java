package com.order.order.repository;

import com.order.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query(value = "SELECT * FROM orders WHERE id = ?1",nativeQuery = true)
    Orders getOrdersByOrderId(Integer orderId);
}
