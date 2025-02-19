package study.service_abstract;

import org.junit.jupiter.api.BeforeEach;
import study.user.code.Level;
import study.user.domain.User;

public class UserDatoTest {

    private User user1;
    private User user2;
    private User user3;
    @BeforeEach
    public void setUp() {
        this.user1 = new User("qwer123", "박성충", "spring11", Level.BASIC, 1, 0);
        this.user2 = new User("asdf1234", "이하길", "spring22", Level.SILVER, 55, 10);
        this.user3 = new User("zxcv1234", "박이김", "spring33", Level.GOLD, 100, 40);
    }
}
