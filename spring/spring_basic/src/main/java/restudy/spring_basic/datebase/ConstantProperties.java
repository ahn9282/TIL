package restudy.spring_basic.datebase;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

public class ConstantProperties {
    @Value("${spring.datasource.url}")
    private String instanceUrl;

    @Value("${spring.datasource.username}")
    private String instanceUsername;

    @Value("${spring.datasource.password}")
    private String instancePassword;

    public static String URL;
    public static String USERNAME;
    public static String PW;

    @PostConstruct
    public void init() {
        URL = instanceUrl;
        USERNAME = instanceUsername;
        PW = instancePassword;
    }
}
