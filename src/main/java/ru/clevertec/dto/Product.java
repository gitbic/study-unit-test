package ru.clevertec.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String name;
    private double price;
    private int weight;
    private MetaInf metaInf;
}