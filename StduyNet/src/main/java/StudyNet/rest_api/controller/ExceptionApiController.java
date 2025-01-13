package StudyNet.rest_api.controller;

import StudyNet.rest_api.data.ErrorResult;
import StudyNet.rest_api.ex.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class ExceptionApiController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandle(IllegalArgumentException ex){
        log.error("[exception Handler] ex", ex);
        return new ErrorResult("BAD", ex.getMessage(), LocalDateTime.now());
    }


    @GetMapping("/api/error/{id}")
    public ResponseEntity<String> getMember(@PathVariable("id") String id) {

        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }
        if (id.equals("bad")) {
            throw new IllegalArgumentException("잘못된 입력 값");
        }
        if (id.equals("no-user")) {
            throw new UserNotFoundException("사용자가 존재하지 않음");
        }

        return  ResponseEntity.ok("ok");
    }
}
