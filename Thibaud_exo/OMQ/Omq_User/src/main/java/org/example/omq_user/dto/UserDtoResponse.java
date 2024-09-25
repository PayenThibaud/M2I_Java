package org.example.omq_user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoResponse {
    private int id_user;
    private String email;
    private String lastname;
    private String firstname;
    private String phone;
    private int role;
}
