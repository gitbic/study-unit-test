package ru.clevertec.service;

import ru.clevertec.dto.Order;
import ru.clevertec.dto.Product;
import ru.clevertec.dto.Shop;
import ru.clevertec.exceptions.OrderException;
import ru.clevertec.exceptions.ProductException;
import ru.clevertec.util.ProductUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductManager {

    private static final Double DISCOUNT_PERCENT = 12.6;

    // Возвращает стоимость заказа со скидкой
    public Double getOrderDiscountCost(List<Order> orders) {
        return orders.stream()
            .map(order -> order.getNumber() * getProductDiscountCost(order.getProduct()))
            .reduce(Double::sum)
            .orElseThrow(() -> new OrderException("wrong order cost calculation"));
    }

    // Возвращает полную стоимость заказа
    public Double getOrderCost(List<Order> orders) {
        return orders.stream()
            .map(order -> order.getNumber() * order.getProduct().getPrice())
            .reduce(Double::sum)
            .orElseThrow(() -> new OrderException("wrong order cost calculation"));
    }

    // Возвращает общий вес заказа
    public Integer getOrderWeight(List<Order> orders) {
        return orders.stream()
            .map(order -> order.getNumber() * order.getProduct().getWeight())
            .reduce(Integer::sum)
            .orElseThrow(() -> new OrderException("wrong order weight calculator"));
    }

    // Возвращает список продуктов в конкретном магазине
    public List<Product> getShopProducts(List<Product> products, Shop shop) {
        return products.stream()
            .filter(product -> product.getMetaInf().getShopList().contains(shop))
            .collect(Collectors.toList());
    }

    // Возвращает товары со скидкой
    public List<Product> getDiscountProductList(List<Product> products) {
        return products.stream()
            .filter(product -> product.getMetaInf().isDiscount())
            .collect(Collectors.toList());
    }

    // Получает продукт по имени
    public Product getProductByName(List<Product> products, String productName) {
        return products.stream()
            .filter(product -> product.getName().equals(productName))
            .findFirst()
            .orElseThrow(() -> new ProductException("Can't find product by name"));
    }

    // Проверяем наличие продукта в списке
    public boolean isProductExist(List<Product> products, String productName) {
        return products.stream()
            .anyMatch(product -> product.getName().equals(productName));
    }

    // Возвращает стоимость продукта со скидкой
    private double getProductDiscountCost(Product product) {
        return Optional.of(product)
            .filter(product1 -> product1.getMetaInf().isDiscount())
            .map(product1 -> product1.getPrice() * ((100 - DISCOUNT_PERCENT) / 100))
            .orElse(product.getPrice());
    }

    // Получаем список продуктов
    private List<Product> getListProduct() {
        return ProductUtils.createProducts();
    }


}
