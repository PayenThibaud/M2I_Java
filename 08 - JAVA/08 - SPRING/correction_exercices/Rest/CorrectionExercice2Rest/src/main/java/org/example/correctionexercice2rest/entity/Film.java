package org.example.correctionexercice2rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.correctionexercice2rest.util.FilmType;

import javax.swing.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private long id;
    private String name;
    private LocalDate releaseDate;
    @Column(columnDefinition = "text")
    private String description;
    private int duration;
    @Enumerated
    private FilmType filmType;

    @ManyToOne
    @JoinColumn(name =  "id_director")
    @JsonIgnore
    private Director director;
}
