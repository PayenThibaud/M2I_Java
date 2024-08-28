package org.example.gestionInventaire.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity

@Table(name = "article_electronique")
public class Article_electronique extends Article{
    private String dureeBatterie;

    @Override
    public String toString() {
        return super.toString() + " duree Batterie: " + dureeBatterie;
    }
}
