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
    String email;

    Level level;

    int login;
    int recommend;

    public void upgradeLevel() {
        Level nextLevel = this.getLevel().nextLevel();
        if (nextLevel == null) {
            throw new IllegalStateException(this.getLevel() + "은 업그레이드가 불가능");
        } else {
            this.setLevel(nextLevel);
        }
    }

}
