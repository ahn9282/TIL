package study.service_abstract.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.mail.SimpleMailMessage;
import study.service_abstract.service.MailSender;
import study.service_abstract.service.UserService;
import study.user.code.Level;
import study.user.dao.UserDaoInterface;
import study.user.domain.User;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;
    private final UserDaoInterface userDao;
    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void upgradeLevels(){
        List<User> users = userDao.getAll();
        for (User user : users) {
            upgradeLevel(user);
        }
    }

    protected void upgradeLevel(User user) {
        if(canUpgradeLevel(user)) {
            user.upgradeLevel();
            userDao.update(user);
            sendUpgradeMail(user);
        }
    }

    @Override
    public void add(User user){
        if(user.getLevel() == null) user.setLevel(Level.BASIC);
        userDao.add(user);
    }
    private boolean canUpgradeLevel(User user){
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

    private void sendUpgradeMail(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("user@ramil.com");
        mailMessage.setTo("Upgrade 안내");
        mailMessage.setTo("사용자 님의 등급이 " + user.getLevel().name());

        mailSender.send(mailMessage);
    }
}
