package org.example.demo_validation.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo_validation.validation.MyValid;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @NotBlank(message = "La valeur ne doit pas être vide !")
    @NotNull(message = "Ce champ doit être rempli !")
    @MyValid()
    private String firstname;
    @Size(min = 3, message = "Minimum 3 lettres svp !")
    private String lastname;
    @Min(value = 18)
    @Max(77)
    private int age;
}
