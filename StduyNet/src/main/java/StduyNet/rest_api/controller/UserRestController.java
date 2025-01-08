package StduyNet.rest_api.controller;

import StduyNet.rest_api.ex.UserNotFoundException;
import StduyNet.rest_api.service.UserRestDaoService;
import StduyNet.rest_api.user.UserRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserRestDaoService service;

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
    public ResponseEntity<UserRest> createUser(@RequestBody UserRest user) {
        UserRest savedUser = service.save(user);

        //헤더에 location : 결과 URI 값이 담겨서 응답하도록 한다.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
