package study.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import study.aop.ProxyCreateTest;
import study.proxy.pointcut.NameMatchClassMethodPointcut;
import study.user.dao.UserDaoInterface;
import study.user.dao.UserDaoJdbc;

import javax.sql.DataSource;

@Configuration
public class TestConfiguration {

    @Bean
    @Qualifier("testUserService")
    public ProxyCreateTest.TestUserService testUserService(){
        return new ProxyCreateTest.TestUserService(testUserDao());
    }
    @Bean
    @Qualifier("testUserDao")
    public UserDaoInterface testUserDao() {
        return new UserDaoJdbc(dataSource());
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource dataSource() {
        return new HikariDataSource();
    }

    @Bean
    @Qualifier("testTransactionPointcut")
    public NameMatchClassMethodPointcut nameMatchClassMethodPointcut() {
        NameMatchClassMethodPointcut pointcut = new NameMatchClassMethodPointcut();
        pointcut.setMappedClassName("*NotServiceImpl");
        pointcut.setMappedName("upgrade*");
        return pointcut;
    }
}
