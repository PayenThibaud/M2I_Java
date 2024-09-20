package org.example.rest_annotation_biblio.DTO.livreDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rest_annotation_biblio.DTO.BiblioDTO.BibliothequeDtoSend;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivreDtoSend {
    private String titre;
    private String auteur;
    private BibliothequeDtoSend bibliotheque;
}
