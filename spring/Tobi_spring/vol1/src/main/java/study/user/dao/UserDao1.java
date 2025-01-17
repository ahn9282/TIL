package study.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDao1 extends UserDao{
    public UserDao1(SimpleConnectionMaker simpleConnectionMaker) {
        super(simpleConnectionMaker);
    }
}