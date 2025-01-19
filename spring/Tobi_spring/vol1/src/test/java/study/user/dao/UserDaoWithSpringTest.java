package study.user.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.user.domain.User;
import study.user.factory.DaoFactory;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
class UserDaoWithSpringTest {

    @Autowired
    private UserDao dao;

    @BeforeEach
    public void setUp() throws SQLException, ClassNotFoundException {
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
