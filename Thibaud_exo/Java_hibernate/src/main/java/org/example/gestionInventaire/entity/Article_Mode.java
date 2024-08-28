package org.example.gestionInventaire.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.gestionInventaire.enums.Categorie;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity

@Table(name = "article_Mode")
public class Article_Mode extends Article{
    private Categorie categorie;
    private int taille;

    @Override
    public String toString() {
        return super.toString() + " categorie : " + categorie + " taille : " + taille;
    }
}
