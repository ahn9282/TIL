package StudyNet.rest_api.service;

import StudyNet.rest_api.data.UserRest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRestDaoService {

    private static List<UserRest> users = new ArrayList<>();

    private static int userCount = 3;

    static{
        users.add(new UserRest(1, "kevin", LocalDate.now(),"1234","1111-1111","VIP"));
        users.add(new UserRest(2, "john", LocalDate.now(),"1234","1111-1111","VIP"));
        users.add(new UserRest(3, "evan", LocalDate.now(),"1234","1111-1111","VIP"));
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
