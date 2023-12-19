package com.github.youssfbr.crud.services;

import com.github.youssfbr.crud.dtos.ProductCreateRequestDTO;
import com.github.youssfbr.crud.dtos.ProductResponseDTO;

import java.util.List;

public interface IProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO createProduct(ProductCreateRequestDTO productCreateRequestDTO);
}
