package study.service_abstract.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.service_abstract.service.UserCRUDPolicy;
import study.service_abstract.service.UserLevelUpgradePolicy;
import study.user.code.Level;
import study.user.dao.UserDaoInterface;
import study.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserLevelUpgradePolicy, UserCRUDPolicy {
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;
    private final UserDaoInterface userDao;

    @Override
    public void upgradeLevels(){
        List<User> users = userDao.getAll();
        for (User user : users) {
            if(canUpgradeLevel(user)) {
                user.upgradeLevel();
                userDao.update(user);
            }
        }
    }
    @Override
    public void add(User user){
        if(user.getLevel() == null) user.setLevel(Level.BASIC);
        userDao.add(user);
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
