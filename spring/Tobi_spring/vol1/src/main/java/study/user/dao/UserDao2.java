package study.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDao2 extends UserDao{

    public UserDao2(SimpleConnectionMaker simpleConnectionMaker) {
        super(simpleConnectionMaker);
    }
}