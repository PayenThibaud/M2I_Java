package org.example.omq_authentification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponseDto {
    private int id;
    private String email;
    private String lastname;
    private String firstname;
    private String phone;
    private int role;
}