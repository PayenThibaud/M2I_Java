package org.example.micro_exo_1suite.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CommandeDtoReceive {
    private String product;
    private String utilisateurId;
}
