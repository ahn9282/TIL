package ajs.til.auth_jwt_redis.domain.user.dto;

import ajs.til.auth_jwt_redis.domain.user.code.UserRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private String phoneNumber;
    private UserRoles roles;
}
