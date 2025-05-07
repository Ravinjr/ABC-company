package com.product.product.services.impl;

import com.product.product.dto.ProductDTO;
import com.product.product.model.Product;
import com.product.product.repository.ProductRepo;
import com.product.product.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceIMPL implements ProductService {
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    public ProductServiceIMPL(ProductRepo productRepo, ModelMapper modelMapper) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return modelMapper.map(products, new TypeToken<List<ProductDTO>>() {}.getType());
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        productRepo.save(modelMapper.map(productDTO, Product.class));
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        productRepo.save(modelMapper.map(productDTO, Product.class));
        return productDTO;
    }

    @Override
    public String deleteProduct(ProductDTO productDTO) {
        productRepo.delete(modelMapper.map(productDTO, Product.class));
        return "Product deleted";
    }

    @Override
    public ProductDTO getProductByProductId(Integer productId) {
        Product product = productRepo.findProductById(productId);
        return modelMapper.map(product, ProductDTO.class);
    }

}
