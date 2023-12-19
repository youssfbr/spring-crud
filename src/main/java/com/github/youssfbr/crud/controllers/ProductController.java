package com.github.youssfbr.crud.controllers;

import com.github.youssfbr.crud.dtos.ProductCreateRequestDTO;
import com.github.youssfbr.crud.dtos.ProductResponseDTO;
import com.github.youssfbr.crud.services.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody @Valid ProductCreateRequestDTO productCreateRequestDTO) {

        final ProductResponseDTO productResponseDTO = productService.createProduct(productCreateRequestDTO);
        final Long id = productResponseDTO.getId();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id).toUri();

        return ResponseEntity.created(location).body(productResponseDTO);
    }

}
