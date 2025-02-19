package study.service_abstract.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.user.code.Level;
import study.user.dao.UserDao;
import study.user.dao.UserDaoInterface;
import study.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDaoInterface userDao;

    public void upgradeLevels(){
        List<User> users = userDao.getAll();
        for (User user : users) {
            Boolean changed = null;
            if (user.getLevel() == Level.BASIC && user.getLogin() >= 50) {
                user.setLevel(Level.SILVER);
                changed = true;
            } else if (user.getLevel() == Level.SILVER && user.getRecommend() >= 30) {
                user.setLevel(Level.GOLD);
                changed = true;
            }else if(user.getLevel() == Level.GOLD){
                changed = false;}
            if(changed) userDao.update(user);
        }
    }

}
