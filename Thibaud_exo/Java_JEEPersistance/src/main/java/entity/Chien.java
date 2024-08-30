package entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Table(name = "chien")
public class Chien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chien")
    private int id;
    private String nom;
    private String race;
    private LocalDate dateDeNaissance;

    @Override
    public String toString() {
        return "Chien = id : " + id + " nom : " + nom + " race : " + race + " dateDeNaissance : ";
    }
}
