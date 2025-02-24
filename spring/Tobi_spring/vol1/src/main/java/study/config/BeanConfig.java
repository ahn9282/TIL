package study.config;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.service_abstract.service.impl.UserService;
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
    public UserService userService(){
        return new UserService(userDao());
    }
    @Bean
    public UserDaoInterface userDao(){
        return new UserDaoJdbc(dataSource());
    }
}
