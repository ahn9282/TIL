package ajs.til.auth_jwt_redis.domain.user.entity;

import ajs.til.auth_jwt_redis.domain.user.code.UserRoles;
import ajs.til.auth_jwt_redis.domain.user.dto.UserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    private String nickname;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRoles roles;

    public static UserEntity of(UserDto dto){

        if (dto == null) return null;

        return UserEntity.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .phoneNumber(dto.getPhoneNumber())
                .roles(dto.getRoles())
                .build();
    }

    public UserDto toDto(){

        return UserDto.builder()
                .id(getId())
                .username(getUsername())
                .password(getPassword())
                .email(getEmail())
                .nickname(getNickname())
                .phoneNumber(getPhoneNumber())
                .roles(getRoles())
                .build();
    }
}
