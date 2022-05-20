package service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import ru.clevertec.dto.MetaInf;
import ru.clevertec.dto.Order;
import ru.clevertec.dto.Product;
import ru.clevertec.dto.Shop;
import ru.clevertec.exceptions.ProductException;
import ru.clevertec.service.ProductManager;
import ru.clevertec.util.OrderUtil;
import ru.clevertec.util.ProductUtils;

import java.time.LocalDate;
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

    @Test
    void getProductByNameTest() {
        Product expectedApple = new Product()
            .setName("apple")
            .setPrice(1.24)
            .setWeight(500)
            .setMetaInf(new MetaInf()
                .setDiscount(false)
                .setExpirationDate(LocalDate.parse("2022-06-03"))
                .setShopList(List.of(
                    Shop.EVROOPT,
                    Shop.DVA_GUSIA,
                    Shop.KOPEECHKA
                ))
            );

        Product apple = productManager.getProductByName(products, "apple");

        Assertions.assertEquals(expectedApple, apple);
    }

    @Test
    void getProductByNameFailedTest() {
        Assertions.assertThrows(ProductException.class,
            () -> productManager.getProductByName(products, "yabloko"));
    }

    // Написать позитивные и негативные тесты для метода isProductExist
    @Test
    void isProductExistTest() {
        boolean isAppleExist = productManager.isProductExist(products, "apple");
        Assertions.assertTrue(isAppleExist);
    }


    @ParameterizedTest
    void isProductNoExistTest() {
        productManager.isProductExist("")
    }
}
