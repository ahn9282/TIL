package study.jpa.Entity.product.abstract_items;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="plane_movie")
public class Movie_A extends ItemAbstract {
    private String actor;

    private String director;
}
