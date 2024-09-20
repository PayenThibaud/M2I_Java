package org.example.correctionexercice2rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_director")
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private String nationality;

    @OneToMany(mappedBy = "director")
    @JsonIgnore
    private List<Film> films;
}
