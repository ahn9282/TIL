package study.jpa.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import study.jpa.Entity.product.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team  extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

}
