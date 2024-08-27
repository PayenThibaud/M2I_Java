package org.example.exo2Product.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
public class Product_Food extends Product{
    private String batterie_duration;

    @Override
    public String toString() {
        return super.toString() + " batterie_duration : " + batterie_duration;
    }
}
