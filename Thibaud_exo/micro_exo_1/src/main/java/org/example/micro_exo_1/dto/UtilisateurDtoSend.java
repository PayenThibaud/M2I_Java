package org.example.micro_exo_1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UtilisateurDtoSend {
    private int id;
    private String nom;
    private String email;
}
