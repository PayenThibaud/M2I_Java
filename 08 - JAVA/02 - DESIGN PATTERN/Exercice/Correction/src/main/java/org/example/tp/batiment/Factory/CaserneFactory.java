package org.example.tp.batiment.Factory;

import org.example.tp.batiment.AbstractBatimentBuilder;
import org.example.tp.batiment.Batiment;
import org.example.tp.batiment.Caserne;
import org.example.tp.batiment.Chateau;

public class CaserneFactory extends BatimentFactory<Caserne, Caserne.CaserneBuilder> {
    @Override
    public Caserne createBatiment(Caserne.CaserneBuilder builder) {
        return (Caserne) builder.build();
    }
}
