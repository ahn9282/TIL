package StduyNet.rest_api.controller;

import StduyNet.rest_api.ex.UserNotFoundException;
import StduyNet.rest_api.service.UserRestDaoService;
import StduyNet.rest_api.user.UserRest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/rest")
public class UserRestController {

    private final UserRestDaoService service;
    private final MessageSource messageSource;

    public UserRestController(UserRestDaoService service, MessageSource messageSource) {
        this.service = service;
        this.messageSource = messageSource;
    }

    @GetMapping("/userRests")
    public List<UserRest> readAllUsers(){
        return service.findAll();
    }

    @GetMapping("/userRests/{id}")
    public UserRest retrieveUser(@PathVariable int id){
        UserRest user = service.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID: %s not found", id));
        }
        return user;
    }


    @PostMapping("/userRests")
    public ResponseEntity<UserRest> createUser(@RequestBody @Valid UserRest user) {
        UserRest savedUser = service.save(user);

        //헤더에 location : 결과 URI 값이 담겨서 응답하도록 한다.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("greeting.message", null, locale);
    }

}
