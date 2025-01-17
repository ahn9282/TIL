package study.user.dao;

import study.user.domain.User;

import java.sql.*;

public abstract class UserDao {
    private SimpleConnectionMaker simpleConnectionMaker;
    public UserDao(SimpleConnectionMaker simpleConnectionMaker) {
        this.simpleConnectionMaker = simpleConnectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection con = simpleConnectionMaker.makeNewConnection();

        PreparedStatement pstmt = con.prepareStatement("insert into users values (?,?,?)");
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());

        pstmt.executeUpdate();

        pstmt.close();
        con.close();

    }


    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection con = simpleConnectionMaker.makeNewConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from users where id = ?");

        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        pstmt.close();
        con.close();

        return user;
    }

}
