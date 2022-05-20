package service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.clevertec.dto.Order;
import ru.clevertec.dto.Product;
import ru.clevertec.service.ProductManager;
import ru.clevertec.util.OrderUtil;
import ru.clevertec.util.ProductUtils;

import java.util.List;

public class ProductManagerTest {

    static List<Product> products;
    List<Order> orders;
    ProductManager productManager = new ProductManager();

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

//    Задача: Написать позитивные и негативные тесты для метода getProductByName
//    Задача: Написать позитивные и негативные тесты для метода getProductByName

}
