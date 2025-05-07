package com.inventory.inventory.services.impl;

import com.inventory.inventory.dto.InventoryDTO;
import com.inventory.inventory.model.Inventory;
import com.inventory.inventory.repository.InventoryRepository;
import com.inventory.inventory.services.InventoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceIMPL implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;

    public InventoryServiceIMPL(InventoryRepository inventoryRepository, ModelMapper modelMapper) {
        this.inventoryRepository = inventoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<InventoryDTO> getItems() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return modelMapper.map(inventories, new TypeToken<List<InventoryDTO>>() {}.getType());
    }

    @Override
    public InventoryDTO addItem(InventoryDTO inventoryDTO) {
        inventoryRepository.save(modelMapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }

    @Override
    public InventoryDTO updateItem(InventoryDTO inventoryDTO) {
       inventoryRepository.save(modelMapper.map(inventoryDTO, Inventory.class));
       return inventoryDTO;
    }

    @Override
    public String deleteItem(InventoryDTO inventoryDTO, int id) {
        inventoryRepository.deleteById(id);
        return "Item deleted";
    }

    @Override
    public InventoryDTO getItemByItemId(Integer itemId) {
        Inventory inventory = inventoryRepository.getItemByItemId(itemId);
        return modelMapper.map(inventory, InventoryDTO.class);
    }


}