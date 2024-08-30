package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity

@Table(name = "article_Nourriture")
public class Article_Nourriture extends Article{

    private String datePeremption;

    @Override
    public String toString() {
        return super.toString() + " date de peremption : " + datePeremption;
    }
}
