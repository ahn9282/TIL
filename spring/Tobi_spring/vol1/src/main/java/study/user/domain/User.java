package study.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.user.code.Level;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    String id;
    String name;
    String password;

    Level level;

    int login;
    int recommend;


}
