package study.user.dao;

import jdk.jfr.DataAmount;

import java.sql.Connection;
import java.sql.SQLException;


public class CountingConnectionMaker implements ConnectionMaker{
    int counter = 0;

    private ConnectionMaker realConnectionMaker;

    public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
        this.realConnectionMaker = realConnectionMaker;
    }

    public int getCounter(){
        return counter;
    }

    @Override
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return realConnectionMaker.makeNewConnection();
    }
}
