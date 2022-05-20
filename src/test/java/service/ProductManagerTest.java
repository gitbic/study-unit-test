package service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.clevertec.dto.Product;
import ru.clevertec.util.ProductUtils;

import java.util.List;

public class ProductManagerTest {

    // Задача: Написать метод @BeforeEach & AfterEach, которые будут создавать и уничтожать список заказов

    static List<Product> products;

    @BeforeAll
    static void createProducts() {
        products = ProductUtils.createProducts();
    }

    @AfterAll
    static void deleteProducts() {
        products = null;
    }
}
