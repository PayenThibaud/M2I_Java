package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data

@Inheritance(strategy = InheritanceType.JOINED)

@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article")
    private int id;
    private String description;
    private int prix;
    private int quantite;
    private String dateDeRestock;

    @ManyToMany
    @JoinTable(name ="article_vente" ,
            joinColumns = @JoinColumn(name = "id_article"),
            inverseJoinColumns = @JoinColumn(name = "id_vente"))
    private List<Vente> ventes = new ArrayList<>();


    @Override
    public String toString() {
        return "Article = description : " + description + " prix : " + prix + " quantite : " + quantite;
    }
}
