package study.user.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import study.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDao {
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection con = connectionMaker.makeNewConnection();

        PreparedStatement pstmt = con.prepareStatement("insert into users values (?,?,?)");
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());

        pstmt.executeUpdate();

        pstmt.close();
        con.close();

    }


    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection con = connectionMaker.makeNewConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from users where id = ?");

        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }
        rs.close();
        pstmt.close();
        con.close();

        if (user == null) throw new EmptyResultDataAccessException(1);

        return user;
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = connectionMaker.makeNewConnection();
            pstmt = con.prepareStatement("delete from users");
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if (pstmt != null) { try{ pstmt.close();} catch (SQLException e) { } }
            if (con != null) { try{  con.close();} catch (SQLException e) { } }
        }
        }

        public int getCount () throws SQLException, ClassNotFoundException {
            Connection con = connectionMaker.makeNewConnection();
            PreparedStatement pstmt = con.prepareStatement("select count(*) from users");
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            rs.next();
            pstmt.close();
            con.close();

            return count;
        }

    }
