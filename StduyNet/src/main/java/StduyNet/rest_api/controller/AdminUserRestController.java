package StduyNet.rest_api.controller;

import StduyNet.rest_api.ex.UserNotFoundException;
import StduyNet.rest_api.service.UserRestDaoService;
import StduyNet.rest_api.user.AdminUserRest;
import StduyNet.rest_api.user.UserRest;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
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


    @GetMapping("/admin/userRests/{id}")
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



}
