package study.service_abstract.service.impl;

import jakarta.mail.internet.InternetAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import study.service_abstract.service.MailSender;
import study.service_abstract.service.UserCRUDPolicy;
import study.service_abstract.service.UserLevelUpgradePolicy;
import study.user.code.Level;
import study.user.dao.UserDaoInterface;
import study.user.domain.User;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserLevelUpgradePolicy, UserCRUDPolicy {
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;
    private final UserDaoInterface userDao;
    private PlatformTransactionManager tm;
    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.tm = transactionManager;
    }


    @Override
    public void upgradeLevels() throws SQLException {
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
        try {
            List<User> users = userDao.getAll();
            for (User user : users) {
                if (canUpgradeLevel(user)) {
                    upgradeLevel(user);
                }
            }
            tm.commit(status);
        } catch (Exception e) {
            tm.rollback(status);
            throw e;
        }
    }

    @Override
    public void add(User user) throws SQLException {
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
        try {
            if (user.getLevel() == null) user.setLevel(Level.BASIC);
            userDao.add(user);
            tm.commit(status);
        } catch (Exception e) {
            tm.rollback(status);
            throw e;
        }
    }

    @Override
    public boolean canUpgradeLevel(User user) {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
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

    protected void upgradeLevel(User user) throws SQLException {
        user.upgradeLevel();
        userDao.update(user);
        sendUpgradeEMail(user);

    }


    private void sendUpgradeEMail(User user) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mail.server.com");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("useradmin@asd.com");
        mailMessage.setSubject("Upgrade 안내");
        mailMessage.setText("사용자 님의 등급이 " + user.getLevel().name() + "로 업그레이드 되셨습니다.");

        mailSender.send(mailMessage);

//        Properties props = new Properties();
//        props.put("mail.smtp.host", "mail.ksug.org");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        Session session = Session.getInstance(props, null);
//        MimeMessage message = new MimeMessage(session);
//        try {
//            message.setFrom(new InternetAddress("useradmin@asd.com"));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress((user.getEmail())));
//            message.setSubject("Upgrade 안내");
//            message.setText("사용자 님의 등급이 " + user.getLevel().name() + "로 업그레이드 되셨습니다.");
//
//            Transport.send(message);
//        } catch (AddressException e) {
//            throw new RuntimeException(e);
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
    }

}
