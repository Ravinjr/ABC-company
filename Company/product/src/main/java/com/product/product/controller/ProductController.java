package com.product.product.controller;

import com.product.product.dto.ProductDTO;
import com.product.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts")
    public List<ProductDTO> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(path = {"/add-product"})
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PutMapping(path = {"/update"})
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }
    @DeleteMapping(path = {"/delete"})
    public String deleteProduct(@RequestBody ProductDTO productDTO) {
        return productService.deleteProduct(productDTO);
    }

    @GetMapping(path = {"/get-product-by-product-id/{productId}"})
    public ProductDTO getProductById(@PathVariable Integer productId) {
        return productService.getProductByProductId(productId);
    }
}
