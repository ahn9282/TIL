package StduyNet.rest_api.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserRest {

    private Integer id;
    private String name;
    private LocalDate joinDate;
}
