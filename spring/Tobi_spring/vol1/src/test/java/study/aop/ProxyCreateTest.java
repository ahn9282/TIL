package study.aop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.config.BeanConfig;
import study.config.TestConfiguration;
import study.service_abstract.ex.TestUserServiceException;
import study.service_abstract.service.UserService;
import study.service_abstract.service.impl.UserServiceImpl;
import study.user.dao.UserDao;
import study.user.dao.UserDaoInterface;
import study.user.domain.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BeanConfig.class, TestConfiguration.class})
public class ProxyCreateTest {

    @Autowired
    @Qualifier("userService")
    UserService userService;
    @Autowired
    @Qualifier("testUserService")
    TestUserService testUserService;
    @Autowired
    @Qualifier("testUserDao")
    UserDaoInterface userDao;
    private List<User> users  = new ArrayList<>();


    @Test
    public void advisorAutoProxyCreator(){
        Assertions.assertThat(testUserService).isNotEqualTo(java.lang.reflect.Proxy.class);
    }

    @Test
    public void upgradeAllOrNothing() throws Exception{
            userDao.deleteAll();
        for (User user : users) {
            userDao.add(user);
        }
        try{
            this.testUserService.upgradeLevels();
            Assertions.fail("TestUserServiceException expected");
        }catch(Exception e){
        }
    }
    @BeforeEach
    public void setup(){
        User user1 = User.builder() .id("user1")  .name("edwin") .password("1111").build();
        User user2 = User.builder() .id("user2")  .name("jason") .password("2222").build();
        User user3 = User.builder() .id("user3")  .name("commi") .password("3333").build();

        users.add(user1);
        users.add(user2);
        users.add(user3);

    }


    public static class TestUserService extends UserServiceImpl {
        private String id = "madnite1";

        public TestUserService(UserDaoInterface userDao) {
            super(userDao);
        }

        protected void upgradeLevel(User user) {
            if (user.getId().equals(this.id)) throw new TestUserServiceException();
            super.upgradeLevel(user);
        }
    }
}
