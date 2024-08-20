package org.example.tp;

import org.example.tp.batiment.BatimentProd;
import org.example.tp.batiment.Caserne;
import org.example.tp.batiment.Chateau;
import org.example.tp.batiment.Factory.CaserneFactory;
import org.example.tp.batiment.Factory.ChateauFactory;
import org.example.tp.batiment.Factory.ForgeFactory;
import org.example.tp.batiment.Forge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ForgeFactory forgeFactory = new ForgeFactory();

        Forge forge = forgeFactory.createBatiment(new Forge.ForgeBuilder().ratioProd(0.5f).taille(2).style("fer"));

        CaserneFactory caserneFactory = new CaserneFactory();

        Caserne caserne = caserneFactory.createBatiment(new Caserne.CaserneBuilder().nbrSoldat(50).taille(25).style("bois"));

        List<BatimentProd> batimentProds = new ArrayList<>();
        batimentProds.add(forge);
        batimentProds.add(caserne);

        ChateauFactory chateauFactory = new ChateauFactory();
        Chateau chateau = chateauFactory.createBatiment(new Chateau.ChateauBuilder().style("Pierre").taille(200).batiment(batimentProds));

        System.out.println(chateau);


    }
}