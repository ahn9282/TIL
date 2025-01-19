package study.user.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import study.user.domain.User;
import study.user.factory.DaoFactory;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class UserDaoTest {

    private UserDao dao;

    @BeforeEach
    public void setUp(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(DaoFactory.class);

        this.dao = ac.getBean("userDao", UserDao.class);
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {

        dao.deleteAll();

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
        assertThat(resultUser.getName()).isEqualTo(resultUser.getName());
        assertThat(resultUser.equals(user)).isTrue();
    }

    @Test
    public void daoExceptionTest() throws SQLException, ClassNotFoundException {

        dao.deleteAll();
        assertThatThrownBy( () -> dao.get("123")).isInstanceOf(EmptyResultDataAccessException.class);
    }


}