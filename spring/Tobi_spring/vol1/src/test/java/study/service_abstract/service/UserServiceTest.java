package study.service_abstract.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;
import study.config.BeanConfig;
import study.service_abstract.service.impl.MockMailSender;
import study.service_abstract.service.impl.UserService;
import study.user.dao.UserDaoInterface;
import study.user.dao.UserDaoJdbc;
import study.user.domain.User;

import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BeanConfig.class)
class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserDaoJdbc userDao;
    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    MailSender mailSender;

    @Test
    @DirtiesContext
    public void upgradeLevels() throws Exception {
        userDao.deleteAll();
        MockMailSender mockMailSender = new MockMailSender();
        userService.setMailSender(mockMailSender);

    }


    @Test
    public void upgradeAllOrNothing() throws Exception{
        userService.setTransactionManager(transactionManager);
        userService.setMailSender(mailSender);

    }

    @Test
    public void beanTest(){
        Assertions.assertThat(userService).isNotNull();
    }
}
