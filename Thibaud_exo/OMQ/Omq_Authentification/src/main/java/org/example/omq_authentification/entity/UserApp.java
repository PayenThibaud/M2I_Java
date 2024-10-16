package org.example.omq_authentification.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.omq_authentification.enums.Role;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    @Column(unique = true)
    private String email;
    private String lastname;
    private String firstname;
    private String phone;
    private String password;
    private Role role;

    public UserApp(String email, String lastname, String firstname, String phone, String password,int role) {
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.phone = phone;
        this.password = password;
        this.role = role == 0 ? Role.USER : Role.ADMIN;
    }
}
