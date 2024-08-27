package org.example.exo1Etudient.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "cour")
public class Cour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cour")
    private int id;
    private String professeur;
    private String matiere;
    private String salle;
    private String horraire;

    @ManyToMany
    @JoinTable(name ="cour_etudient" ,
    joinColumns = @JoinColumn(name = "id_cour"),
    inverseJoinColumns = @JoinColumn(name = "id_etudient"))
    private List<Etudient> etudients;

    public void addEtudient(Etudient etudient) {etudients.add(etudient);}

    @Override
    public String toString() {
        return "(Cour = professeur : " + professeur + " matiere : " + matiere + " salle : " + salle + " horraire : " + horraire + ")";
    }

}
