package com.demo.orderservice.entity;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String name;
    private Integer stock;
    private Integer version;
}
