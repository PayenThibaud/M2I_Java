package org.example.Demo2.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Fleuriste {
    private int id;
    private String name;
    private List<Commande> commandes;
}
