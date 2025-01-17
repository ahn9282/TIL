package study.user;

import study.user.dao.UserDao;
import study.user.dao.UserDao1;
import study.user.domain.User;

import java.sql.SQLException;

public class UserMain_1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao1();

        User user = new User();
        user.setId("java2");
        user.setName("자바");
        user.setPassword("1234");

        dao.add(user);

        System.out.println("user = " + user.getId() + "  등록 성공!!");

        User user2 = dao.get("java");
        System.out.println("user2\'s id : " + user2.getId());
        System.out.println("user2\'s pw : " + user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");

    }
}
