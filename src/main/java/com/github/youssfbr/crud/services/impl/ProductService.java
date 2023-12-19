package com.github.youssfbr.crud.services.impl;

import com.github.youssfbr.crud.dtos.ProductCreateRequestDTO;
import com.github.youssfbr.crud.dtos.ProductResponseDTO;
import com.github.youssfbr.crud.entities.Product;
import com.github.youssfbr.crud.repositories.IProductRepository;
import com.github.youssfbr.crud.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponseDTO::new)
                .toList();
    }

    @Override
    @Transactional
    public ProductResponseDTO createProduct(ProductCreateRequestDTO productCreateRequestDTO) {
        final Product productToCreate = new Product(productCreateRequestDTO);
        final Product productCreated = productRepository.save(productToCreate);
        return new ProductResponseDTO(productCreated);
    }
}
