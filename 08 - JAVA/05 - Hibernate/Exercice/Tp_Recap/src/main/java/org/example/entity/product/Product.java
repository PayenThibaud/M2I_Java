package org.example.entity.product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.entity.Sell;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Product {
    @Id
    @GeneratedValue
    @Column(name = "id_product")
    private int id;
    private String description;
    private float price;
    private int stock;
    private LocalDate restockDate;

    @ManyToMany(mappedBy = "products")
    private List<Sell> sells;

}
