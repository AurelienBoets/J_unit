package entity;

import org.example.model.Product;
import org.example.model.ProductEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    private Product product;

    @Test
    void productWithDateDelay() {
        product = new Product("test", 0, 45);
        product.update();
        Assertions.assertEquals(43, product.getQuality());
    }

    @Test
    void productWith0Quality() {
        product = new Product("test", 0, 0);
        product.update();
        Assertions.assertEquals(0, product.getQuality());
    }

    @Test
    void productWith50Quality() {
        Product product = new Product("Brie vieilli", 20, 50, ProductEnum.CHEESE);
        product.update();
        Assertions.assertEquals(50, product.getQuality());
    }

    @Test
    void productWithQualityIncrease() {
        product = new Product("Brie vieilli", 20, 4, ProductEnum.CHEESE);
        product.update();
        Assertions.assertEquals(5, product.getQuality());
    }

    @Test
    void dairyProductWithQualityDecreaseFaster() {
        product = new Product("lait", 10, 15, ProductEnum.DAIRY);
        product.update();
        Assertions.assertEquals(13, product.getQuality());
    }
}
