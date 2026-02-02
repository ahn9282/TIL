package ajs.til.auth_jwt_redis.web.api;

import ajs.til.auth_jwt_redis.common.provider.JwtProvider;
import ajs.til.auth_jwt_redis.domain.user.dto.TokenResponseDto;
import ajs.til.auth_jwt_redis.domain.user.dto.UserDto;
import ajs.til.auth_jwt_redis.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody UserDto userDto) {
        UserDto created = userService.crate(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto loginRequest) {
        // 1. ID/PW 검증
        UserDto user = userService.validate(loginRequest);
        
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        // 2. 토큰 생성
        String accessToken = jwtProvider.create(user, JwtProvider.JwtTokeType.ACCESS);
        String refreshToken = jwtProvider.create(user, JwtProvider.JwtTokeType.REFRESH);

        // 3. 응답 반환
        TokenResponseDto tokenResponse = TokenResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .expiresIn((long) JwtProvider.JWT_EXPIRE_DURATION_MILLI_SECONDS)
                .build();

        return ResponseEntity.ok(tokenResponse);
    }
    
    @GetMapping("/me")
    public ResponseEntity<?> me(@RequestAttribute(value = "userId", required = false) String userId) {
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok("Hello, User ID: " + userId);
    }
}
