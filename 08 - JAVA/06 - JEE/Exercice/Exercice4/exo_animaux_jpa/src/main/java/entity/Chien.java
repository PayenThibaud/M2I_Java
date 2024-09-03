package entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "chien")
public class Chien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chien")
    private int idChien;
    @Column(name = "nom_chien")
    private String nomChien;
    @Column(name = "race")
    private String race;
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    public Chien(String nomChien, String race, LocalDate dateNaissance) {
        this.nomChien = nomChien;
        this.race = race;
        this.dateNaissance = dateNaissance;
    }


}
