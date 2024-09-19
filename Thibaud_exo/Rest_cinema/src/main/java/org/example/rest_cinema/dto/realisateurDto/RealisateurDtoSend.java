package org.example.rest_cinema.dto.realisateurDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealisateurDtoSend {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String nationalite;
}
