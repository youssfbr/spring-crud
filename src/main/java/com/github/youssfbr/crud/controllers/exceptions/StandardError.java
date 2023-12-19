package com.github.youssfbr.crud.controllers.exceptions;

public record StandardError(
        String timestamp ,
        String status ,
        String error ,
        String path
) {
}