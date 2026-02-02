package ajs.til.auth_jwt_redis.common.provider;

import ajs.til.auth_jwt_redis.domain.user.dto.UserDto;
import io.hypersistence.tsid.TSID;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.MacAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtProvider {

    private static final MacAlgorithm DEFAULT_JWT_ALGORITHM = Jwts.SIG.HS256;
    private final static SecretKey SECRET_KEY = DEFAULT_JWT_ALGORITHM.key().build();
    public static final int JWT_EXPIRE_DURATION_MILLI_SECONDS = 3600000;

    public String create(UserDto user, JwtTokeType type){
        String jws = Jwts.builder()
                .header()
                    .type("JWT")
                .and()
                .id(type.name() + "_" + TSID.fast().toString())
                .issuer("JSA")
                .subject(user.getId().toString())
                .claim("role", user.getRoles())
                .claim("email", user.getEmail())
                .claim("userName", user.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + JWT_EXPIRE_DURATION_MILLI_SECONDS))
                .signWith(SECRET_KEY)
                .compact();

        return jws;
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public static enum JwtTokeType {
        ACCESS,
        REFRESH,
        ;
    }
}
