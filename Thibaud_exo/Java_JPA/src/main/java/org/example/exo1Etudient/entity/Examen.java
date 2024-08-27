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
@Table(name = "examen")
public class Examen {
    @Id
    @GeneratedValue
    @Column(name = "id_examen")
    private int id;
    private String date;
    private int note;
    private String matiere;

    @ManyToOne
    @JoinColumn(name = "id_etudient")
    private Etudient etudient;

    @Override
    public String toString() {
        return "(Examen = date : " + date + " note : " + note + " matiere : " + matiere + ")";
    }
}
