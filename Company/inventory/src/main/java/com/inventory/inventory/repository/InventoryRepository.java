package com.inventory.inventory.repository;

import com.inventory.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
    @Query(value = "SELECT * FROM inventory WHERE item_id = ?1", nativeQuery = true)
    Inventory getItemByItemId(Integer itemId);


}
