package restudy.spring_basic.connection;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@SpringBootTest
public class testConnection {


    @Value("${spring.datasource.url}")
    public String URL;
    @Value("${spring.datasource.username}")
    public String USERNAME;
    @Value("${spring.datasource.password}")
    public String PW;

    @Test
    void driverManager() throws SQLException {
        Connection connection1 = DriverManager.getConnection(URL, USERNAME, PW);
        Connection connection2 = DriverManager.getConnection(URL, USERNAME, PW);
        log.info("connection1 = {}, class ={}", connection1, connection1.getClass());
        log.info("connection2 = {}, class ={}", connection2, connection2.getClass());
    }


    @Test
    void dateSourceConnectionPool() throws SQLException, InterruptedException {

    //커넥션 풀링
    HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PW);
        dataSource.setMaximumPoolSize(10);
        dataSource.setPoolName("MyPool");

        useDataSource(dataSource);
        Thread.sleep(1000);


    }
    private void useDataSource(DataSource dataSource) throws SQLException {
        Connection connection1 = dataSource.getConnection();
        Connection connection2 = dataSource.getConnection();
        log.info("connection1 = {}, class ={}", connection1, connection1.getClass());
        log.info("connection2 = {}, class ={}", connection2, connection2.getClass());
    }
}
