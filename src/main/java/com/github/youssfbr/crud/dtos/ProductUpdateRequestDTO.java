package com.github.youssfbr.crud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductUpdateRequestDTO(

        Long id ,
        @NotBlank
        String name ,
        @NotNull
        BigDecimal price
) {
}
