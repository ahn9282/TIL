package study.etc.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.etc.dummy_object.TestUserService;
import study.etc.dummy_object.DummyMailSender;
import study.service_abstract.service.MailSender;
import study.service_abstract.service.UserService;

@Configuration
public class TestAppContext {

    @Bean
    @Qualifier("testBeanUserService")
    public UserService testUserService(){
        return new TestUserService();
    }

    @Bean
    @Qualifier("TestBeanMailSender")
    public MailSender mailSender(){
        return new DummyMailSender();
    }
}
