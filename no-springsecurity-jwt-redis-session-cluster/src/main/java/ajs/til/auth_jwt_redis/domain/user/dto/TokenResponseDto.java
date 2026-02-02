package ajs.til.auth_jwt_redis.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDto {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long expiresIn;
}
