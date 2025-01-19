package study.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.user.dao.CountingConnectionMaker;
import study.user.dao.UserDao;
import study.user.factory.CountingDaoFactory;
import study.user.factory.DaoFactory;

import java.sql.SQLException;

public class UserDaoCountingConnectionTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(CountingDaoFactory.class);

        ac.getBean("countingUserDao", UserDao.class);

        CountingConnectionMaker ccm = ac.getBean("countingConnectionMaker", CountingConnectionMaker.class);
        System.out.println("ccm = " + ccm);
    }
}
