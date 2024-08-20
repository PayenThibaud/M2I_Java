package org.example.tp.batiment.Factory;

import org.example.tp.batiment.AbstractBatimentBuilder;
import org.example.tp.batiment.Batiment;

public abstract class BatimentFactory<T,T2> {
    public abstract T createBatiment (T2 builder);
}
