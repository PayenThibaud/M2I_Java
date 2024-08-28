package org.example.gestionInventaire.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int id;
    private String nom;
    private String mail;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private List<Vente> ventes = new ArrayList<>();


    @Override
    public String toString() {
        return "Client = nom : " + nom + ", mail : " + mail;
    }
}
