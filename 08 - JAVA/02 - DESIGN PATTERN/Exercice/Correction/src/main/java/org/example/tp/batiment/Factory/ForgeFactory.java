package org.example.tp.batiment.Factory;

import org.example.tp.batiment.AbstractBatimentBuilder;
import org.example.tp.batiment.Batiment;
import org.example.tp.batiment.Forge;

public class ForgeFactory extends BatimentFactory<Forge, Forge.ForgeBuilder> {


    @Override
    public Forge createBatiment(Forge.ForgeBuilder builder) {
        return (Forge) builder.build();
    }
}
