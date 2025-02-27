package study.service_abstract.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.config.BeanConfig;
import study.service_abstract.service.impl.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BeanConfig.class)
class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    public void beanTest(){
        Assertions.assertThat(userService).isNotNull();
    }

}
