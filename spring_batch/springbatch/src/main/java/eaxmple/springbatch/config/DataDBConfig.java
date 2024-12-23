package eaxmple.springbatch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(basePackages = "example.springbatch.repository",
entityManagerFactoryRef = "dataEntityManager",
transactionManagerRef = "dataTransactionManager")
public class DataDBConfig {
    
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-data")
    public DataSource dataDatDBSource(){
    return DataSourceBuilder.create().build();
    }
    
    @Primary
    @Bean
    public PlatformTransactionManager dataTransactionManager(){
        return new DataSourceTransactionManager(dataDatDBSource());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean dataEntityManager(){

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(dataDatDBSource());
        em.setPackagesToScan(new String[]{"example.springbatch.entity"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
        em.setJpaPropertyMap(properties);

        return em;
    }

  
}
