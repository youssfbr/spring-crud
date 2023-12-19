package com.github.youssfbr.crud.services.impl;

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
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
