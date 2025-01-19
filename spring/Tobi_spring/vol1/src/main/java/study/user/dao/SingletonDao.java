package study.user.dao;

import study.user.domain.User;

import java.sql.Connection;
import java.sql.SQLException;

public class SingletonDao {

    private ConnectionMaker connectionMaker;
    private Connection con;
    private User user;

    public User get(String id) throws SQLException, ClassNotFoundException {
        this.con = connectionMaker.makeNewConnection();
        this.user.setId(id);
        this.user.setName("name");


        return user;
    }
}
