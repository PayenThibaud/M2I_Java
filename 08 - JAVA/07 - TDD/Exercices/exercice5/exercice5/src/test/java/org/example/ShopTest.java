package org.example;

import org.junit.Assert;
import org.junit.Test;

public class ShopTest {
    private final Shop shop = new Shop();


    // A la fin de chaque journée le système utilise une méthode update qui décrémente la valeur de SellIn d’un produit.
    @Test
    public void updateTest_DESC_SellIn_Simple()
    {
        Product product = new Product("simple","name",10,10);

        shop.Update(product);



        Assert.assertEquals(9, product.sellIn);
    }

    //le nombre de jours restant pour vendre le produit ne peut pas etre negatif.
    @Test
    public void updateTest_DESC_SellIn_0()
    {
        Product product = new Product("simple","name",0,10);

        shop.Update(product);

        Assert.assertEquals(0, product.sellIn);
    }


    // A la fin de chaque journée le système utilise une méthode update qui décrémente la valeur de quality d’un produit.
    @Test
    public void updateTest_DESC_Quality_Simple_Product()
    {
        Product product = new Product("simple","name",10,10);

        shop.Update(product);

        Assert.assertEquals(9, product.quality);
    }


    // Une fois la date de péremption est à zéro, la qualité se dégrade deux fois plus vite.
    @Test
    public void updateTest_DESC_Quality_Simple_Product_SellIn_0()
    {
        Product product = new Product("simple","name",0,10);

        shop.Update(product);

        Assert.assertEquals(8, product.quality);
    }


    //Les produits laitiers (non brie) se dégradent en qualité deux fois plus vite que les produits normaux date de peremption superieur a 0.
    @Test
    public void updateTest_DESC_Quality_La_Product_Not_Brie()
    {
        Product product = new Product("laitiers","name",10,10);

        shop.Update(product);

        Assert.assertEquals(8, product.quality);
    }


    //Les produits laitiers (non brie) se dégradent en qualité deux fois plus vite que les produits normaux date de peremption a 0.
    @Test
    public void updateTest_DESC_Quality_La_Product_Not_Brie_SellIn_0()
    {
        Product product = new Product("laitiers","name",0,10);

        shop.Update(product);

        Assert.assertEquals(6, product.quality);
    }

    // La qualité d'un article n'est jamais négative.
    @Test
    public void updateTest_DESC_Quality_0_Not_Brie()
    {
        Product product = new Product("simple","name",10,-1);

        shop.Update(product);

        Assert.assertEquals(0, product.quality);
    }


    // La qualité d'un article n'est jamais supérieure à 50.
    @Test
    public void updateTest_ASC_Quality_50()
    {
        Product product = new Product("simple","name",10,51);


        shop.Update(product);

        Assert.assertEquals(50, product.quality);
    }

    // La qualité du « brie vieilli » augmente à mesure qu'il vieillit.
    @Test
    public void updateTest_Quality_Brie()
    {

        Product product = new Product("laitiers","Brie",10,10);

        shop.Update(product);

        Assert.assertEquals(11, product.quality);
    }
}
