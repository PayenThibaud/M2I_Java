package org.example.omq_user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.omq_user.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    private String email;
    private String lastname;
    private String firstname;
    private String phone;
    private Role role;
}
