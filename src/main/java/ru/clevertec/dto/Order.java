package ru.clevertec.dto;

import lombok.Data;

@Data
public class Order {
    Product product;
    int number;
}
