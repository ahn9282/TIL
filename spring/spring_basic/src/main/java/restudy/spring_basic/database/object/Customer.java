package restudy.spring_basic.database.object;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Customer {
    private String member_id;
    private String name;
    private Integer money;

}
