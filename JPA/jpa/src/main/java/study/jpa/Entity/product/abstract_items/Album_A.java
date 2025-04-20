package study.jpa.Entity.product.abstract_items;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="plane_album")
public class Album_A  extends ItemAbstract {
    private String artist;
}
