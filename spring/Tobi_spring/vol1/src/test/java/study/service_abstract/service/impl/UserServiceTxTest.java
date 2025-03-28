package study.service_abstract.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.config.BeanConfig;
import study.service_abstract.service.UserService;
import study.user.dao.UserDaoInterface;
import study.user.domain.User;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BeanConfig.class)
class UserServiceTxTest {

    @Autowired
    @Qualifier("userService")
    UserService userService;
    @Autowired
    @Qualifier("userServiceImpl")
    UserServiceImpl userServiceImpl;

    @Test
    public void upgradeLevels() throws Exception {
        MockMailSender mockMailSender = new MockMailSender();
        assertThat(userServiceImpl).isNotNull();
        assertThat(mockMailSender).isNotNull();
        userServiceImpl.setMailSender(mockMailSender);
    }

    static class MockUserDao implements UserDaoInterface {

        @Override
        public void add(User user) {
            System.out.println("User : " + user + " is saved");
        }

        @Override
        public User findById(String id) {
            User user = new User();
            user.setId(id);
            return user;
        }

        @Override
        public void update(User user) {
            System.out.println("User : " + user + " is updated");
        }

        @Override
        public void deleteById(String id) {
            System.out.println("id : " + id + " is deleted");
        }

        @Override
        public void deleteAll() {
            System.out.println("all deleted");
        }

        @Override
        public List<User> getAll() {
            return List.of();
        }
    }
}