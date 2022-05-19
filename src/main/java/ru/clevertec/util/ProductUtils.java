package ru.clevertec.util;

import ru.clevertec.dto.MetaInf;
import ru.clevertec.dto.Product;
import ru.clevertec.dto.Shop;

import java.time.LocalDate;
import java.util.List;

public class ProductUtils {
    public static List<Product> createProducts() {
        return List.of(
            new Product()
                .setName("banana")
                .setPrice(2.02)
                .setWeight(500)
                .setMetaInf(new MetaInf()
                    .setDiscount(true)
                    .setExpirationDate(LocalDate.parse("2022-06-08"))
                    .setShopList(List.of(
                        Shop.ALMI,
                        Shop.DVA_GUSIA
                    ))
                ),
            new Product()
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
                ),
            new Product()
                .setName("potato")
                .setPrice(0.87)
                .setWeight(1000)
                .setMetaInf(new MetaInf()
                    .setDiscount(true)
                    .setExpirationDate(LocalDate.parse("2022-09-14"))
                    .setShopList(List.of(
                        Shop.ALMI
                    ))
                ),
            new Product()
                .setName("carrot")
                .setPrice(3.51)
                .setWeight(1000)
                .setMetaInf(new MetaInf()
                    .setDiscount(false)
                    .setExpirationDate(LocalDate.parse("2022-09-08"))
                    .setShopList(List.of(
                        Shop.DVA_GUSIA,
                        Shop.EVROOPT
                    ))
                ),
            new Product()
                .setName("orange")
                .setPrice(4.18)
                .setWeight(500)
                .setMetaInf(new MetaInf()
                    .setDiscount(false)
                    .setExpirationDate(LocalDate.parse("2022-07-24"))
                    .setShopList(List.of(
                        Shop.EVROOPT,
                        Shop.ALMI,
                        Shop.KOPEECHKA
                    ))
                ),
            new Product()
                .setName("egg")
                .setPrice(1.50)
                .setWeight(400)
                .setMetaInf(new MetaInf()
                    .setDiscount(true)
                    .setExpirationDate(LocalDate.parse("2022-06-25"))
                    .setShopList(List.of(
                        Shop.ALMI,
                        Shop.DVA_GUSIA,
                        Shop.EVROOPT,
                        Shop.KOPEECHKA
                    ))
                ),
            new Product()
                .setName("lemon")
                .setPrice(3.87)
                .setWeight(100)
                .setMetaInf(new MetaInf()
                    .setDiscount(false)
                    .setExpirationDate(LocalDate.parse("2022-10-10"))
                    .setShopList(List.of(
                        Shop.ALMI,
                        Shop.KOPEECHKA
                    ))
                ),
            new Product()
                .setName("bread")
                .setPrice(0.89)
                .setWeight(300)
                .setMetaInf(new MetaInf()
                    .setDiscount(true)
                    .setExpirationDate(LocalDate.parse("2022-05-25"))
                    .setShopList(List.of(
                        Shop.KOPEECHKA
                    ))
                ),
            new Product()
                .setName("milk")
                .setPrice(0.96)
                .setWeight(900)
                .setMetaInf(new MetaInf()
                    .setDiscount(false)
                    .setExpirationDate(LocalDate.parse("2022-11-11"))
                    .setShopList(List.of(
                        Shop.EVROOPT,
                        Shop.DVA_GUSIA,
                        Shop.KOPEECHKA
                    ))
                ),
            new Product()
                .setName("fish")
                .setPrice(5.15)
                .setWeight(800)
                .setMetaInf(new MetaInf()
                    .setDiscount(false)
                    .setExpirationDate(LocalDate.parse("2022-09-26"))
                    .setShopList(List.of(
                        Shop.DVA_GUSIA,
                        Shop.EVROOPT
                    ))
                ),
            new Product()
                .setName("chicken")
                .setPrice(6.82)
                .setWeight(800)
                .setMetaInf(new MetaInf()
                    .setDiscount(false)
                    .setExpirationDate(LocalDate.parse("2022-12-17"))
                    .setShopList(List.of(
                        Shop.ALMI,
                        Shop.DVA_GUSIA,
                        Shop.KOPEECHKA,
                        Shop.EVROOPT
                    ))
                )
        );
    }
}
