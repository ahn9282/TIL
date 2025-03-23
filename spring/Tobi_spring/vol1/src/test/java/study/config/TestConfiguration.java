package study.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import study.aop.ProxyCreateTest;
import study.proxy.pointcut.NameMatchClassMethodPointcut;
import study.service_abstract.service.MailSender;
import study.service_abstract.service.impl.JavaMailSenderImpl;
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
        return new UserDaoJdbc(testDataSource());
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Qualifier("testDataSource")
    public DataSource testDataSource() {
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


    @Bean
    public TransactionManager transactionManager(){
        return new DataSourceTransactionManager(testDataSource());
    }

    @Bean
    @Qualifier("testMailSender")
    public MailSender testMailSender() {
        return new JavaMailSenderImpl();
    }
}
