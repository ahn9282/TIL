package StduyNet.rest_api.controller;

import StduyNet.rest_api.ex.UserNotFoundException;
import StduyNet.rest_api.service.UserRestDaoService;
import StduyNet.rest_api.user.AdminUserRest;
import StduyNet.rest_api.user.UserRest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name="user-controller", description = "일반 사용자 서비스를 위한 컨트롤러")
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


    @Operation(summary = "사용자 정보 조회 API", description = "사용자 ID를 이용하여 사용자 상세 정보 조회를 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description="OK!!"),
            @ApiResponse(responseCode = "400", description="BAD REQUEST!!"),
            @ApiResponse(responseCode = "404", description="USER NOT FOUND!!"),
            @ApiResponse(responseCode = "500", description="INTERNAL SERVER ERROR!!"),

        }
    )
    @GetMapping("/userRests/{id}")
    public EntityModel<UserRest> retrieveUser(@PathVariable int id){
        UserRest user = service.findOne(id);

        AdminUserRest adminUser = new AdminUserRest();
        if(user == null){
            throw new UserNotFoundException(String.format("ID: %s not found", id));
        }

        EntityModel entityModel = EntityModel.of(user);

        WebMvcLinkBuilder linTo = linkTo(methodOn(this.getClass()).readAllUsers());
        entityModel.add(linTo.withRel("all-users"));

        return entityModel;
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
