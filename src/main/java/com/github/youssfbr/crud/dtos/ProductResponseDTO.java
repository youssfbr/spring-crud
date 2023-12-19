package com.github.youssfbr.crud.dtos;

import com.github.youssfbr.crud.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private Long id;
    private String name;
    private BigDecimal price;

    public ProductResponseDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
    }
}
