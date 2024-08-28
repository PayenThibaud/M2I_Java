package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.entity.product.Product;
import org.example.util.SellStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sell")
    private int id;
    private LocalDate sellDate;
    private SellStatus sellStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_customer")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "sell_product"
            ,joinColumns = @JoinColumn(name = "id_sell")
    ,inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> products;
}
