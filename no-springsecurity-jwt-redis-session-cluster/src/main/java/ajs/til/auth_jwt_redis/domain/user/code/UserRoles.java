package ajs.til.auth_jwt_redis.domain.user.code;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserRoles {

    ROLE_ADMIN(true),
    ROLE_MANAGER(true),
    ROLE_CUSTOMER(false),
    GUEST(false),
    ;

    private final boolean isOperator;

    private static UserRoles from(String str) {
        try {
            return UserRoles.valueOf(str);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new RoleNotExistException();
        }
    }

    public static class RoleNotExistException extends RuntimeException{}
}
