package study.config;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import study.service_abstract.service.UserService;
import study.service_abstract.service.impl.UserServiceImplWithTransactionManager;
import study.service_abstract.service.impl.UserServiceImpl;
import study.service_abstract.service.impl.UserServiceTx;
import study.user.dao.UserDaoInterface;
import study.user.dao.UserDaoJdbc;

import javax.sql.DataSource;

@Configuration
public class BeanConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new HikariDataSource();
    }
    @Bean
    public UserServiceImplWithTransactionManager userServiceDoubleImpl(){
        return new UserServiceImplWithTransactionManager(userDao());
    }
    @Bean
    public UserDaoInterface userDao(){
        return new UserDaoJdbc(dataSource());
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
    @Bean
    public UserService userService(){
        return new UserServiceTx(userServiceImpl(), platformTransactionManager());
    }

    @Bean
    public UserServiceImpl userServiceImpl(){
        return new UserServiceImpl(userDao());
    }
}
