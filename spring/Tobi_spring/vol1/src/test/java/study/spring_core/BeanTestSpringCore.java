package study.spring_core;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import study.config.BeanConfig;
import study.config.TestConfiguration;

@SpringBootTest
//@ContextConfiguration(classes = BeanConfig.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class BeanTestSpringCore {

    @Autowired
    DefaultListableBeanFactory bf;

    @Test
    public void beans(){

        for(String n : bf.getBeanDefinitionNames()){
            System.out.println(n + " \t "  + bf.getBean(n).getClass().getSimpleName());
        }
    }
}
