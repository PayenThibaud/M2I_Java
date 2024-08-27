package org.example.exo1Etudient.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adresse")
    private int id;
    private int numero;
    private int rue;
    private String ville;
    private int codePostal;

    @OneToOne(mappedBy = "adresse")
    private Etudient etudient;

    @Override
    public String toString() {
        return "(Adresse = rue : " + rue + " ville : " + ville + " codePostal : " + codePostal +")";
    }
}


