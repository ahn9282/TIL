package study.jpa.Entity.product.item;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("A")
public class Album  extends Item {
    private String artist;
}
