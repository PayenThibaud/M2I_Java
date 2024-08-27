package org.example.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public class ProductFood extends Product {
    private Date expiryDate;

    @Override
    public String toString() {
        return "ProductFood{" +
                "expiryDate=" + expiryDate +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
