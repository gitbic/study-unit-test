package ru.clevertec.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MetaInf {
    private LocalDate expirationDate;
    private boolean isDiscount;
    private List<Shop> shopList;
}