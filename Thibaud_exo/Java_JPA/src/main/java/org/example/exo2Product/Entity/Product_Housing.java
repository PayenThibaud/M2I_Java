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
public class Product_Housing extends Product{
    private int height;
    private int width;

    @Override
    public String toString() {
        return super.toString() + " height : " + height + " width : " + width;
    }
}
