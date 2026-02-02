package ajs.til.auth_jwt_redis.domain.user.service;

import ajs.til.auth_jwt_redis.domain.user.dto.UserDto;

public interface UserService {

    UserDto crate(UserDto user);

    UserDto validate(UserDto user);
}
