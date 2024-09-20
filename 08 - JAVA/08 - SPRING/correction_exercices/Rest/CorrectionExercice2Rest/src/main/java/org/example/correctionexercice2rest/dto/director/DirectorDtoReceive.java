package org.example.correctionexercice2rest.dto.director;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectorDtoReceive {
    @Size(max = 255)
    private String firstname;
    @Size(max = 255)
    private String lastname;
    @Pattern(regexp = "([0-9]+(-[0-9]+)+)")
    private String birthDateStr;
    @Size(max = 255)
    private String nationality;
}
