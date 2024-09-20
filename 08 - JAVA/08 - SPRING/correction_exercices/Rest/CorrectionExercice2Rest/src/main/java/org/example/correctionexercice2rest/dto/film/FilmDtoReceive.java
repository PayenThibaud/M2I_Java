package org.example.correctionexercice2rest.dto.film;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDtoReceive {
    @Size(max = 255)
    private String name;
    @Pattern(regexp = "([0-9]+(-[0-9]+)+)")
    private String releaseDateStr;
    private String description;
    @Positive
    private int duration;
    @Min(0)
    @Max(8)
    private int filmType;
    @NotNull
    private int directorId;
}
