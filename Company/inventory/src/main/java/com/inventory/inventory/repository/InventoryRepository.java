package com.inventory.inventory.repository;

import com.inventory.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
    Inventory getInventoryById(int id);
}
