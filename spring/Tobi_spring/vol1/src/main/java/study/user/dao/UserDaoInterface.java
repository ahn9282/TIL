package study.user.dao;

import study.user.domain.User;

import java.util.List;

public interface UserDaoInterface {

    void add(User user);

    User findById(String id);

    void update(User user);

    void deleteById(String id);

    void deleteAll();

    List<User> getAll();
}
