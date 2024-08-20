package org.example.tp.batiment.Factory;

import org.example.tp.batiment.AbstractBatimentBuilder;
import org.example.tp.batiment.Batiment;
import org.example.tp.batiment.Chateau;

public class ChateauFactory extends BatimentFactory<Chateau, Chateau.ChateauBuilder> {

    @Override
    public Chateau createBatiment(Chateau.ChateauBuilder builder) {
        return (Chateau) builder.build();
    }
}
