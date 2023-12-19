package com.github.youssfbr.crud.entities;

import com.github.youssfbr.crud.dtos.ProductCreateRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_product")
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    public Product(ProductCreateRequestDTO productCreateRequestDTO) {
        name = productCreateRequestDTO.name();
        price = productCreateRequestDTO.price();
    }
}
