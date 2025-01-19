package study.user.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.user.dao.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao1(connectionMaker());
        return userDao;
    }
    public UserDao userDaoV1(){
        UserDao userDao = new UserDao1(connectionMaker());
        return userDao;
    }
    public UserDao userDaoV2(){
        UserDao userDao = new UserDao1(connectionMaker());
        return userDao;
    }


    @Bean
    public ConnectionMaker connectionMaker(){
        return new V1ConnectionMaker();
    }
}
