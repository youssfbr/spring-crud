package com.github.youssfbr.crud.services;

import com.github.youssfbr.crud.dtos.ProductCreateRequestDTO;
import com.github.youssfbr.crud.dtos.ProductDeleteRequestDTO;
import com.github.youssfbr.crud.dtos.ProductResponseDTO;
import com.github.youssfbr.crud.dtos.ProductUpdateRequestDTO;

import java.util.List;

public interface IProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO createProduct(ProductCreateRequestDTO productCreateRequestDTO);
    ProductResponseDTO updateProduct(ProductUpdateRequestDTO productUpdateRequestDTO);
    void deleteProduct(ProductDeleteRequestDTO productDeleteRequestDTO);
}
