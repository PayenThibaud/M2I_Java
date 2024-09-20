package org.example.rest_annotation_biblio.DTO.livreDTO;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rest_annotation_biblio.entity.Bibliotheque;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivreDtoReceive {
    private String titre;
    private String auteur;
    private String nom_bibliotheque;
}
