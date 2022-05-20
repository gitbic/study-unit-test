package service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import resolver.ProductParameterResolver;
import ru.clevertec.dto.MetaInf;
import ru.clevertec.dto.Order;
import ru.clevertec.dto.Product;
import ru.clevertec.dto.Shop;
import ru.clevertec.exceptions.ProductException;
import ru.clevertec.service.ProductManager;
import ru.clevertec.util.OrderUtil;
import ru.clevertec.util.ProductUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(ProductParameterResolver.class)
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

    // Задача: Написать параметризированный тест метода isProductExist
    // Позитивный тест с @MethodSource
    // Негативный тест с @ValueSource

    private static Stream<String> getValidProducts() {
        return Stream.of(
            "apple",
            "orange",
            "banana",
            "carrot"
        );
    }

    @ParameterizedTest
    @MethodSource("getValidProducts")
    void isProductExistTest(String productName) {
        boolean productExist = productManager.isProductExist(products, productName);
        Assertions.assertTrue(productExist);
    }

    @ParameterizedTest
    @ValueSource(strings = {"kefir", "smetana"})
    void isProductNoExistTest(String productName) {
        boolean productExist = productManager.isProductExist(products, productName);
        Assertions.assertFalse(productExist);
    }

    // Задача: Создать тест с именем, который получает список продуктов со скидкой
    // и проверяет скидки в каждом продукте

    @Test
    @DisplayName("Тест на получение списка продуктов со скидкой")
    void getDiscountProductListTest() {
        List<Product> discountProductList = productManager.getDiscountProductList(products);

        discountProductList
            .forEach(product -> Assertions.assertTrue(product.getMetaInf().isDiscount()));
    }

    // Задача: Создать @TestFactory для проверки содержания продуктов в определенном магазине getShopProducts

    @TestFactory
    Stream<DynamicTest> getShopProductsDynamicTest() {
        return Arrays.stream(Shop.values())
            .map(shop -> DynamicTest.dynamicTest("shopName: " + shop.name(),
                () -> {
                    List<Product> products = productManager.getShopProducts(ProductManagerTest.products, shop);
                    products.forEach(product ->
                        Assertions.assertTrue(product.getMetaInf().getShopList().contains(shop)));
                }));
    }

    // Задача: Создать ProductParameterResolver, возвращающий рандомный продукт
    // Поставить аннотацию над классом @ExtendWith(ProductParameterResolver.class)
    // Проверить получение продукта по имени getProductByNameTest

    @Test
    void getProductByNameNewTest(Product product) {
        String productName = product.getName();
        Product productByName = productManager.getProductByName(products, productName);

        Assertions.assertEquals(product, productByName);
    }

}
