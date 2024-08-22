package org.example.Demo2.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Commande {
    private int id;
    private float prix;
    private int quantite;
    private Plante plante;

}
