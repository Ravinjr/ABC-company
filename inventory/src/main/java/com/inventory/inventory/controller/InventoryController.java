package com.inventory.inventory.controller;

import com.inventory.inventory.dto.InventoryDTO;
import com.inventory.inventory.services.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory/")
@CrossOrigin
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @GetMapping(path = "getitems")
    public List<InventoryDTO> getItems(){
        return inventoryService.getItems();
    }
    @PostMapping(path = {"/add-item"})
    public InventoryDTO addItem(@RequestBody InventoryDTO inventoryDTO){
        return inventoryService.addItem(inventoryDTO);
    }
    @PutMapping(path = {"/update-item"})
    public InventoryDTO updateOrder(@RequestBody InventoryDTO inventoryDTO){
        return inventoryService.updateItem(inventoryDTO);
    }
    @DeleteMapping(path = {"/delete-item/{id}"})
    public String deleteOrder(@RequestBody InventoryDTO inventoryDTO, @PathVariable int id){
        return inventoryService.deleteItem(inventoryDTO,id);
    }
    @GetMapping(path = {"/get-inventory-by-id/{id}"})
    public InventoryDTO getInventoryById(@PathVariable int id){
        return inventoryService.getInventoryById(id);
    }
}
