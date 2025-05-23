package com.inventory.inventory.dto;

public class InventoryDTO {
    private int id;
    private int itemId;
    private int productId;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public InventoryDTO() {
    }

    public InventoryDTO(int id, int itemId, int productId, int quantity) {
        this.id = id;
        this.itemId = itemId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
