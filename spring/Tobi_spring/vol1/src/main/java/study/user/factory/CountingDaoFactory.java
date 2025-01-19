package study.user.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.user.dao.*;

@Configuration
public class CountingDaoFactory {

    @Bean(name = "countingUserDao")
    public UserDao userDao(){
        UserDao userDao = new UserDao1(connectionMaker());
        return userDao;
    }

    @Bean(name = "countingConnectionMaker")
    public ConnectionMaker connectionMaker(){
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean(name = "realCountingConnectionMaker")
    public ConnectionMaker realConnectionMaker(){
        return new V1ConnectionMaker();
    }
}
