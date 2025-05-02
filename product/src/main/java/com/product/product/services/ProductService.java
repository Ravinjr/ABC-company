package com.product.product.services;

import com.product.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO updateProduct(ProductDTO productDTO);

    String deleteProduct(ProductDTO productDTO);
}
