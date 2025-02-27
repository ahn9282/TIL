package study.service_abstract.service;

import study.user.domain.User;

public interface UserLevelUpgradePolicy {
    boolean canUpgradeLevel(User user);

    void upgradeLevels();

}
