package ajs.til.auth_jwt_redis.domain.user.service.impl;

import ajs.til.auth_jwt_redis.domain.user.dto.UserDto;
import ajs.til.auth_jwt_redis.domain.user.entity.UserEntity;
import ajs.til.auth_jwt_redis.domain.user.repository.UserEntityRepository;
import ajs.til.auth_jwt_redis.domain.user.service.UserService;
import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserEntityRepository userRepository;

    @Override
    public UserDto crate(UserDto user) {

        Long id = TSID.fast().toLong();
        UserEntity created = UserEntity.of(user);
        created.setPassword(passwordEncoder.encode(user.getPassword()));
        created.setId(id);

        UserEntity saved = userRepository.save(created);
        return saved.toDto();
    }

    @Override
    public UserDto validate(UserDto userDto) {
        if (userDto == null || userDto.getUsername() == null || userDto.getPassword() == null) {
            log.warn("(validate user) fail - request data is invalid");
            return null;
        }

        Optional<UserEntity> userEntityOp = userRepository.findByUsername(userDto.getUsername());

        if (userEntityOp.isEmpty()) {
            log.warn("(validate user) fail - user not found: {}", userDto.getUsername());
            return null;
        }

        UserEntity userEntity = userEntityOp.get();

        if (!passwordEncoder.matches(userDto.getPassword(), userEntity.getPassword())) {
            log.warn("(validate user) fail - password mismatch: {}", userDto.getUsername());
            return null;
        }

        return userEntity.toDto();
    }
}
