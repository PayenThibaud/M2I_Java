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
@Table(name = "etudient")
public class Etudient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etudient")
    private int id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    private String classe;

    @OneToOne
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    @OneToMany(mappedBy = "etudient")
    private List<Examen> examens;

    @ManyToMany(mappedBy = "etudients")
    private List<Cour> cours;

    public void addCour(Cour cour) {
        cours.add(cour);
    }

    @Override
    public String toString() {
        return "(Etudient = nom : " + nom + " prenom : " + prenom + " classe : " + classe + " adresse : " + adresse  + " examens : " + examens + " cours : " + cours + ")";
    }
}
