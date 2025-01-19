package study.user.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import study.user.domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DirtiesContext
class UserDaoDirtiesContextTest {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    private UserDao dao;

    @BeforeEach
    public void setUp() throws SQLException, ClassNotFoundException {
        DataSource dataSource = new SingleConnectionDataSource(url, username, password, false);
        Connection con = dataSource.getConnection();
        this.dao = new UserDao1(new V1ConnectionMaker());
        dao.deleteAll();
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setId("1234");
        user.setName("mark");
        user.setPassword("ssdd");

        int cntBeforeAdd = dao.getCount();
        dao.add(user);
        int cntAfterAdd = dao.getCount();

        User resultUser = dao.get("1234");

        assertThat(cntBeforeAdd).isEqualTo(0);
        assertThat(cntAfterAdd).isEqualTo(1);
        assertThat(resultUser.getName()).isEqualTo("mark");
        assertThat(resultUser.equals(user)).isTrue();
    }

    @Test
    public void daoExceptionTest() throws SQLException, ClassNotFoundException {
        assertThatThrownBy(() -> dao.get("123"))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }
}
