package entity;

import enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Table(name = "vente")
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vente")
    private int id;
    private String date;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToMany( fetch = FetchType.EAGER, mappedBy = "ventes")
    private List<Article> articles = new ArrayList<>();

    @Override
    public String toString() {
        return  "Vente = id : " + id + ", date : " + date + ", status : " + status +  " client id : " + client.getId();
    }

}
