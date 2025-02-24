package study.service_abstract.service;

import study.user.domain.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserLevelUpgradePolicy {
    boolean canUpgradeLevel( User user);

    void upgradeLevels() throws SQLException;

}
