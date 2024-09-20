package org.example.rest_annotation_biblio.DTO.BiblioDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BibliothequeDtoSend {
    private String nom;
    private String lieu;
}
