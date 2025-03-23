package study.spring_core;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "spring_core")
@Import({AppContext.TestAppContext.class, AppContext.ProductionAppContext.class})
@PropertySource("/database.properties")
public class AppContext {

    @Value("${db.driverClass}")
    Class<? extends Driver> drivetClass;
    @Value("${db.url}")
    String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    String password;

    @Autowired
    Environment env;


    @Bean
    @Qualifier("productionHikariDataSource")
    public DataSource productionHikariDataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();

        try {
            ds.setDriverClass((Class<? extends Driver>) Class.forName(env.getProperty("db.driverClass")));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ds.setUrl(env.getProperty("db.url"));
        ds.setUrl(env.getProperty("db.username"));
        ds.setUrl(env.getProperty("db.password"));

        return ds;
    }


    //각 profile 별로 중첩 클래스의 @Configuration을 통해 bean 등록 분리

    @Configuration
    @Profile("production")
    public static class ProductionAppContext {
        @Bean
        @ConfigurationProperties(prefix = "spring.datasource")
        @Qualifier("productionHikariDataSource")
        public DataSource productionHikariDataSource() {
            return new HikariDataSource();
        }
    }

    @Configuration
    @Profile("test")
    public static class TestAppContext {
        @Bean
        @ConfigurationProperties(prefix = "spring.datasource")
        @Qualifier("testHikariDataSource")
        public DataSource testDataSource() {
            return new HikariDataSource();
        }
    }
}
