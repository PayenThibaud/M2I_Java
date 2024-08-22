package org.example.Demo2.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFleuriste {
    private int id;
    private Commande commande;
    private Fleuriste fleuriste;
}
