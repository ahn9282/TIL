package study.jpa.Entity.product.abstract_items;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("B")
@Table(name="plane_book")
public class Book_A extends ItemAbstract {
    private String author;

    private String isbn;
}
