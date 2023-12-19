package com.github.youssfbr.crud.services.impl;

import com.github.youssfbr.crud.dtos.ProductCreateRequestDTO;
import com.github.youssfbr.crud.dtos.ProductDeleteRequestDTO;
import com.github.youssfbr.crud.dtos.ProductResponseDTO;
import com.github.youssfbr.crud.dtos.ProductUpdateRequestDTO;
import com.github.youssfbr.crud.entities.Product;
import com.github.youssfbr.crud.repositories.IProductRepository;
import com.github.youssfbr.crud.services.IProductService;
import com.github.youssfbr.crud.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private static final String MESSAGE_ID_NOT_FOUND = "Resource not found with ID ";

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

    @Override
    @Transactional
    public ProductResponseDTO updateProduct(ProductUpdateRequestDTO productUpdateRequestDTO) {

        final Product productToUpdate = existsProduct(productUpdateRequestDTO.id());
        BeanUtils.copyProperties(productUpdateRequestDTO, productToUpdate);

        final Product productUpdated = productRepository.save(productToUpdate);
        return new ProductResponseDTO(productUpdated);
    }

    @Override
    @Transactional
    public void deleteProduct(ProductDeleteRequestDTO productDeleteRequestDTO) {

        existsProduct(productDeleteRequestDTO.id());

        productRepository.deleteById(productDeleteRequestDTO.id());
    }

    private Product existsProduct(Long id) {
        return productRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(MESSAGE_ID_NOT_FOUND + id));
    }
}
