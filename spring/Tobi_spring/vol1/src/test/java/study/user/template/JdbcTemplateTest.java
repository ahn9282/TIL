package study.user.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import study.template_3.JdbcTemplateUserDao;
import study.user.domain.User;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class JdbcTemplateTest {
    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private JdbcTemplateUserDao dao;

    User user1;
    User user2;
    User user3;

    @Test
    public void getAll() {
        jdbcTemplate.update("delete from users");

        dao.add(user1);
        User saved1 = dao.get(user1.getId());
        assertThat(user1.equals(saved1)).isTrue();

        dao.add(user2);
        User saved2 = dao.get(user2.getId());
        assertThat(user2.equals(saved2)).isTrue();

        dao.add(user3);
        User saved3 = dao.get(user3.getId());
        assertThat(user3.equals(saved3)).isTrue();
    }


    @BeforeEach
    public void setUp() throws SQLException {
        Mockito.when(dataSource.getConnection()).thenReturn(connection);
        dao = new JdbcTemplateUserDao(dataSource);

        user1 = User.builder()
                .id("1111")
                .name("user1")
                .password("1111")
                .build();
        user2 = User.builder()
                .id("2222")
                .name("user2")
                .password("2222")
                .build();
        user3 = User.builder()
                .id("3333")
                .name("user3")
                .password("3333")
                .build();
    }

}
