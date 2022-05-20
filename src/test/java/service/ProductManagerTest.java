package service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.clevertec.dto.Product;
import ru.clevertec.util.ProductUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerTest {

    // Задача: Написать метод @BeforeAll & AfterAll, которые будут создавать и уничтожать список продуктов

    static List<Product> products = new ArrayList<>();

    @BeforeAll
    static void createProducts() {
        products = ProductUtils.createProducts();
    }

    @AfterAll
    static void deleteProducts() {
        products = null;
    }

}
