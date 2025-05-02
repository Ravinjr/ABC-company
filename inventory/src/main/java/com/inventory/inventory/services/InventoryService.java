package com.inventory.inventory.services;

import com.inventory.inventory.dto.InventoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<InventoryDTO> getItems();

    InventoryDTO addItem(InventoryDTO inventoryDTO);

    InventoryDTO updateItem(InventoryDTO inventoryDTO);

    String deleteItem(InventoryDTO inventoryDTO, int id);

    InventoryDTO getInventoryById(int id);
}
