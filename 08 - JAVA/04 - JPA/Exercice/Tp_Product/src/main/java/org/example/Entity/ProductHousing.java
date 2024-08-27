package org.example.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public class ProductHousing extends Product {
    private int height;
    private int width;

    @Override
    public String toString() {
        return "ProductHousing{" +
                "height=" + height +
                ", width=" + width +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
