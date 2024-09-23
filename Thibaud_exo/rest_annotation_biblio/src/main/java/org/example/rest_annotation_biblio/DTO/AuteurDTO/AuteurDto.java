package org.example.rest_annotation_biblio.DTO.AuteurDTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AuteurDto {
    private int id;
    private String nom;
    private String prenom;
}
