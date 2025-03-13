package study.service_abstract.service.impl;

import lombok.RequiredArgsConstructor;
import study.service_abstract.service.UserService;
import study.user.dao.UserDao;
import study.user.dao.UserDaoInterface;
import study.user.domain.User;

@RequiredArgsConstructor
public class CoreService implements UserService {
    private final UserDaoInterface userDao;

    @Override
    public void add(User user) {

    }

    @Override
    public void upgradeLevels() {

    }
}
