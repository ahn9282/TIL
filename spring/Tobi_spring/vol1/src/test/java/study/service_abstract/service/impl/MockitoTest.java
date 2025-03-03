package study.service_abstract.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.config.BeanConfig;
import study.user.code.Level;
import study.user.dao.UserDaoInterface;
import study.user.domain.User;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BeanConfig.class)
public class MockitoTest {

    @Mock
    private UserDaoInterface mockUserDao;
    @InjectMocks
    private UserServiceImpl userService;
    private List<User> users = new ArrayList<>();

    @Test
    public void testUserServiceMock() {

        when(mockUserDao.getAll()).thenReturn(this.users);

        userService.upgradeLevels();

        verify(mockUserDao, times(2)).add(any(User.class));
        verify(mockUserDao, times(2)).update(any(User.class));
    }
    @BeforeEach
    public void setUp() {
        User user1 = User.builder()
                .id("user1")
                .name("firstUser")
                .password("pw123")
                .email("firstUser@example.com")
                .level(Level.BASIC)
                .login(30)
                .recommend(5)
                .build();

        User user2 = User.builder()
                .id("user2")
                .name("secondUser")
                .password("pw123")
                .email("secondUser@example.com")
                .level(Level.SILVER)
                .login(100)
                .recommend(15)
                .build();

        users.add(user1);
        users.add(user2);

        userService.add(user1);
        userService.add(user2);
    }
}
