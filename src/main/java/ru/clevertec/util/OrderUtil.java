package ru.clevertec.util;

import ru.clevertec.dto.Order;
import ru.clevertec.dto.Product;
import ru.clevertec.service.ProductManager;

import java.util.List;

public class OrderUtil {

    public static List<Order> createOrders() {

        List<Product> products = ProductUtils.createProducts();
        ProductManager productManager = new ProductManager();

        return List.of(
            new Order()
                .setProduct(productManager.getProductByName(products, "banana"))
                .setNumber(2),
            new Order()
                .setProduct(productManager.getProductByName(products, "orange"))
                .setNumber(4),
            new Order()
                .setProduct(productManager.getProductByName(products, "banana"))
                .setNumber(5),
            new Order()
                .setProduct(productManager.getProductByName(products, "milk"))
                .setNumber(1),
            new Order()
                .setProduct(productManager.getProductByName(products, "chicken"))
                .setNumber(2)
        );
    }
}
