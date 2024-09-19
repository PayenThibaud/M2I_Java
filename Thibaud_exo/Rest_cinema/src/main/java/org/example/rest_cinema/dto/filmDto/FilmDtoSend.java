package org.example.rest_cinema.dto.filmDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rest_cinema.dto.realisateurDto.RealisateurDtoSend;
import org.example.rest_cinema.entity.Realisateur;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDtoSend {
    private String nom;
    private String description;
    private LocalDate dateDeSortie;
    private int duree;
    private String genre;
    private RealisateurDtoSend realisateur;
}
