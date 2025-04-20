package study.jpa.Entity.product.abstract_items;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="abstract_item")
public abstract class ItemAbstract {

    @Id
    @Column(name="item_id")
    private Long Id;

    private Integer price;

    private String name;
}
