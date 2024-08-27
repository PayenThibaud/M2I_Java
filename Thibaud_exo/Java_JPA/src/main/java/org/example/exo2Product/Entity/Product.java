package org.example.exo2Product.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data

@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Double price;

    @Override
    public String toString() {
        return "Product = name : " + name + " price : " + price;
    }
}
