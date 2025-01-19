package study.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.user.dao.UserDao;
import study.user.dao.UserDao1;
import study.user.dao.V1ConnectionMaker;
import study.user.domain.User;
import study.user.factory.DaoFactory;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ApplicationContext ac = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = ac.getBean("userDao", UserDao.class);

        System.out.println("dao = " + dao);
    }
}
