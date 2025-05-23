package study.jpa.Entity.product.item;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("M")
public class Movie extends Item {
    private String actor;

    private String director;
}
