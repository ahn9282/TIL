package study.service_abstract.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import study.service_abstract.service.UserCRUDPolicy;
import study.service_abstract.service.UserLevelUpgradePolicy;
import study.user.code.Level;
import study.user.dao.UserDaoInterface;
import study.user.domain.User;

import java.util.List;

//@Service
@RequiredArgsConstructor
public class UserServiceImplWithTransactionManager implements UserLevelUpgradePolicy, UserCRUDPolicy {
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;
    private final UserDaoInterface userDao;
    private PlatformTransactionManager tm ;

    public void setTransactionManager(PlatformTransactionManager tm) {
        this.tm = tm;
    }

    @Override
    public void upgradeLevels() {
        // 트랜잭션 시작
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());

        try {
            List<User> users = userDao.getAll();
            for (User user : users) {
                if (canUpgradeLevel(user)) {
                    user.upgradeLevel();
                    userDao.update(user);
                }
            }
            tm.commit(status);
        } catch (RuntimeException e) {
            tm.rollback(status);
            throw e;
        }
    }

    @Override
    public void add(User user) {
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());

        try {
            if (user.getLevel() == null) user.setLevel(Level.BASIC);
            userDao.add(user);

            tm.commit(status);
        } catch (RuntimeException e) {
            tm.rollback(status);
            throw e;
        }
    }
    @Override
    public boolean canUpgradeLevel(User user){
        Level currentLevel = user.getLevel();
        switch(currentLevel){
            case BASIC:
                return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER:
                return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
            case GOLD:
                return false;
            default:
                throw new IllegalStateException("Unknown Level : " + currentLevel);
        }
    }
}
