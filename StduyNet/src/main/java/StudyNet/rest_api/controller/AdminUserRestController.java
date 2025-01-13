package StudyNet.rest_api.controller;

import StudyNet.rest_api.ex.UserNotFoundException;
import StudyNet.rest_api.service.UserRestDaoService;
import StudyNet.rest_api.data.AdminUserRest;
import StudyNet.rest_api.data.UserRest;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/rest/admin")
public class AdminUserRestController {

    private final UserRestDaoService service;

    public AdminUserRestController(UserRestDaoService service) {
        this.service = service;
    }

    @GetMapping("/userRests")
    public MappingJacksonValue readAllUsers(){
        List<UserRest> users = service.findAll();
        List<AdminUserRest> adminUsers = new ArrayList<>();
        for (UserRest user : users) {
            AdminUserRest adminUser = new AdminUserRest();
            BeanUtils.copyProperties(user, adminUser);
            adminUsers.add(adminUser);
        }


        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUsers);
        mapping.setFilters(filters);

        return mapping;
    }


    @GetMapping(value = "/userRest/{id}", params="version=1")
    public MappingJacksonValue retrieveUser4Admin(@PathVariable int id){
        UserRest user = service.findOne(id);

        AdminUserRest adminUser = new AdminUserRest();
        if(user == null){
            throw new UserNotFoundException(String.format("ID: %s not found", id));
        }else{
            BeanUtils.copyProperties(user, adminUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);

        return mapping;
    }
    @GetMapping(value = "/userRest/{id}", params="version=2")
    public MappingJacksonValue retrieveUser4AdminV2(@PathVariable int id){
        UserRest user = service.findOne(id);

        AdminUserRest adminUser = new AdminUserRest();
        if(user == null){
            throw new UserNotFoundException(String.format("ID: %s not found", id));
        }else{
            BeanUtils.copyProperties(user, adminUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "grade");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping(value = "/userRest/{id}", headers="X-API-VERSION=1")
    public MappingJacksonValue retrieveUser4AdminHeader(@PathVariable int id){
        UserRest user = service.findOne(id);

        AdminUserRest adminUser = new AdminUserRest();
        if(user == null){
            throw new UserNotFoundException(String.format("ID: %s not found", id));
        }else{
            BeanUtils.copyProperties(user, adminUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);

        return mapping;
    }
    @GetMapping(value = "/userRest/{id}", headers="X-API-VERSION=2")
    public MappingJacksonValue retrieveUser4AdminHeaderV2(@PathVariable int id){
        UserRest user = service.findOne(id);

        AdminUserRest adminUser = new AdminUserRest();
        if(user == null){
            throw new UserNotFoundException(String.format("ID: %s not found", id));
        }else{
            BeanUtils.copyProperties(user, adminUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "grade");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);

        return mapping;
    }



}
