package org.example._08_demo_spring_rest.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "table_user")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private String password;
}
