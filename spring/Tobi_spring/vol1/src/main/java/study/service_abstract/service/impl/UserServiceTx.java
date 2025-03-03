package study.service_abstract.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import study.service_abstract.service.UserService;
import study.user.domain.User;

public class UserServiceTx implements UserService {

    private final UserService userService;
    private final PlatformTransactionManager tm;

    @Autowired
    public UserServiceTx(@Qualifier("userServiceImpl") UserService userService, PlatformTransactionManager tm) {
        this.userService = userService;
        this.tm = tm;
    }
    @Override
    public void add(User user) {
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
        System.out.println("transaction on");
        try {
            userService.add(user);
            tm.commit(status);
        } catch (Exception e) {
            tm.rollback(status);
            throw e;
        }finally{

        System.out.println("transaction off");
        }
    }

    @Override
    public void upgradeLevels() {
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
        System.out.println("transaction on");
        try {
            userService.upgradeLevels();
            tm.commit(status);
        } catch (Exception e) {
            tm.rollback(status);
            throw e;
        }finally{

            System.out.println("transaction off");
        }
    }
}
