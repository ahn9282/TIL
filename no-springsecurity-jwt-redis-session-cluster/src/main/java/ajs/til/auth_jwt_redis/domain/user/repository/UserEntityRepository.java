package ajs.til.auth_jwt_redis.domain.user.repository;

import ajs.til.auth_jwt_redis.domain.user.dto.UserDto;
import ajs.til.auth_jwt_redis.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    Optional<UserEntity> findByUsername(String userName);
}
