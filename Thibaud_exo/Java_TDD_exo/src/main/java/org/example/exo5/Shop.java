package org.example.exo5;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product) {

        product.setSellIn(product.getSellIn() -1);
        product.setQuality(product.getQuality() - 1);

        if (product.getName().equals("brie vieilli")) {
//            if (product.getQuality() < 50) {
                product.setQuality(product.getQuality() + 2);
//            }
        }

        if (product.getType().equals("Laitier")) {
//            if (product.getQuality() > 1) {
                product.setQuality(product.getQuality() - 1);
//            }
        }

        if (product.getSellIn() <= 0) {
//            if (product.getQuality() >= 0) {
                product.setQuality(product.getQuality() - 1);
//            }
        }

        if (product.getQuality() > 50 || product.getQuality() < 0) {
            throw new QualiteException();
        }
    }
}