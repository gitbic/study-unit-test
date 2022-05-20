package service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.clevertec.dto.Order;
import ru.clevertec.dto.Product;
import ru.clevertec.util.OrderUtil;
import ru.clevertec.util.ProductUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerTest {

    // Задача: Написать метод @BeforeEach & AfterEach, которые будут создавать и уничтожать список заказов

    static List<Product> products;
    List<Order> orders;

    @BeforeAll
    static void createProducts() {
        products = ProductUtils.createProducts();
    }

    @AfterAll
    static void deleteProducts() {
        products = null;
    }

    @BeforeEach
    void createOrders() {
        orders = OrderUtil.createOrders();
    }

    @AfterEach
    void deleteOrders() {
        orders = null;
    }

}
