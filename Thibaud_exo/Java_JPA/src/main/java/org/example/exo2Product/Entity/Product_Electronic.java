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
public class Product_Electronic extends Product{
    private String expiry_date;

    @Override
    public String toString() {
        return super.toString() + " expiry_date : " + expiry_date;
    }
}
