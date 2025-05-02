package com.product.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    private int id;
    private int productId;
    private String productName;
    private String description;
    private int forSale;
}
