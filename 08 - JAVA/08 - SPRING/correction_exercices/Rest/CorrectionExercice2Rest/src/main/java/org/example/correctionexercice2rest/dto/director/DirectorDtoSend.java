package org.example.correctionexercice2rest.dto.director;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.correctionexercice2rest.entity.Film;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectorDtoSend {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private String nationality;
    private List<Film> films;
}
