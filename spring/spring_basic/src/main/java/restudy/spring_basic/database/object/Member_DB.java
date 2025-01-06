package restudy.spring_basic.database.object;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member_DB {
    @Id
    private String member_id;
    private String name;
    private Long money;

}
