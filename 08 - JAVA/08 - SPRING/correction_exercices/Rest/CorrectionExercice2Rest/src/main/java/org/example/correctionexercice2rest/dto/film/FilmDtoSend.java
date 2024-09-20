package org.example.correctionexercice2rest.dto.film;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.correctionexercice2rest.entity.Director;
import org.example.correctionexercice2rest.util.FilmType;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDtoSend {
    private long id;
    private String name;
    private LocalDate releaseDate;
    private String description;
    private int duration;
    private FilmType filmType;
    private Director director;
}
