package study.service_abstract.service;

import study.user.domain.User;

public interface UserService {

    void add(User user);
    void upgradeLevels();
}
