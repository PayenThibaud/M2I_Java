package org.example.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public class ProductElectronic extends Product {

    private int batterieDuration;

    @Override
    public String toString() {
        return "ProductElectronic{" +
                "batterieDuration=" + batterieDuration +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

