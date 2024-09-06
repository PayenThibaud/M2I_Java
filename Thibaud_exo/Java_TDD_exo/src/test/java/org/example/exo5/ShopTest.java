package org.example.exo5;

import org.example.exo4.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {

    private Shop shop;

    @BeforeEach
    public void setUp() {
        shop = new Shop();
    }

    @Test
    public void TestShopSellIn_0_ThenQualite_degraded_2x() {
        // Arrange
        Product product = new Product("Fruit", "Poire", 0, 30);
        Product product2 = new Product("Fruit", "Poire", -1, 28);

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(product.getQuality(), product2.getQuality());
    }

    @Test
    public void TestShopQualite_negative_ThenQualiteException() {
        // Arrange
        Product product = new Product("Fruit", "Poire", 109, -50);

        // Act Assert
        Assertions.assertThrows(QualiteException.class, () -> {
            shop.update(product);
        });
    }

    @Test
    public void TestShopQualite_above_50_ThenQualiteException() {
        // Arrange
        Product product = new Product("Fruit", "Poire", 109, 200);

        // Act Assert
        Assertions.assertThrows(QualiteException.class, () -> {
            shop.update(product);
        });
    }

    @Test
    public void TestShopBrieVieilli_ThenQualite_Upgrade_with_SellIn_minus() {
        // Arrange
        Product product = new Product("Fromage", "brie vieilli", 50, 40);
        Product product2 = new Product("Fromage", "brie vieilli", 49, 41);

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(product.getQuality(), product2.getQuality());
    }

    @Test
    public void TestShopBrieVieilli_And_Qualite_is_49_ThenThrowQualiteException() {
        // Arrange
        Product product = new Product("Fromage", "brie vieilli", 50, 49);
        
        // Act
        shop.update(product);

        // Assert
        Assertions.assertThrows(QualiteException.class, () -> {
            shop.update(product);
        });
    }

    @Test
    public void TestShopProduct_is_Laitier_ThenQualite_degraded_2x() {
        // Arrange
        Product product = new Product("Laitier", "Lait", 50, 30);
        Product product2 = new Product("Laitier", "Lait", 49, 28);

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(product.getQuality(), product2.getQuality());
    }
}
