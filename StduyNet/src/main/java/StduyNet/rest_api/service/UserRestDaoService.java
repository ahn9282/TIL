package StduyNet.rest_api.service;

import StduyNet.rest_api.user.UserRest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserRestDaoService {

    private static List<UserRest> users = new ArrayList<>();

    private static int userCount = 3;

    static{
        users.add(new UserRest(1, "kevin", LocalDate.now()));
        users.add(new UserRest(2, "john", LocalDate.now()));
        users.add(new UserRest(3, "evan", LocalDate.now()));
    }

    public List<UserRest> findAll(){
        return users;
    }
    public UserRest findOne(int id){
        for (UserRest user : users) {
            if(id == user.getId()) return user;
        }
        return null;
    }

    public UserRest save(UserRest user){
        if(user.getId() == null){
            user.setId(++userCount);

        }
        if(user.getJoinDate() == null){
            user.setJoinDate(LocalDate.now());
        }
        users.add(user);
        return user;
    }

}