package study.service_abstract.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import study.service_abstract.service.UserService;
import study.user.domain.User;

public class UserServiceTx implements UserService {

    private UserService userService;
    private PlatformTransactionManager tm;

    public UserServiceTx(UserService userService, PlatformTransactionManager tm) {
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
