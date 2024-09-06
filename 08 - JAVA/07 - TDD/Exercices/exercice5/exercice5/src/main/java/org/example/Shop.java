package org.example;

public class Shop {

    public Shop() {
    }
    public void Update(Product product)
    {
        if(product.quality <= 0)  // La qualité d'un article n'est jamais négative.
        {
            product.quality = 0;  // La qualité d'un article n'est jamais négative.
        }
        else if(product.quality >= 50) // La qualité d'un article n'est jamais supérieure à 50.
        {
            product.quality = 50; // La qualité d'un article n'est jamais supérieure à 50.
        }
        else
        {
            if (product.type.equals("laitiers") )
            {
                if(product.name.equals("Brie") ) // La qualité du « brie vieilli » augmente à mesure qu'il vieillit.
                {
                    product.quality++; // La qualité du « brie vieilli » augmente à mesure qu'il vieillit.
                }else
                {
                    if (product.sellIn == 0)
                        product.quality -= 4; //Les produits laitiers (non brie) se dégradent en qualité deux fois plus vite que les produits normaux date de peremption a 0.
                    else
                        product.quality -= 2; //Les produits laitiers (non brie) se dégradent en qualité deux fois plus vite que les produits normaux date de peremption superieur a 0.
                }

            }
            else
            {
                if (product.sellIn == 0) // Une fois la date de péremption est à zéro, la qualité se dégrade deux fois plus vite.
                    product.quality -= 2; // Une fois la date de péremption est à zéro, la qualité se dégrade deux fois plus vite.
                else
                    product.quality -= 1; // A la fin de chaque journée le système utilise une méthode update qui décrémente la valeur de quality d’un produit.
            }
        }

        if(product.sellIn > 0)  //le nombre de jours restant pour vendre le produit ne peut pas etre negatif.
        {
            product.sellIn--; // A la fin de chaque journée le système utilise une méthode update qui décrémente la valeur de SellIn d’un produit.
        }
    }
}
