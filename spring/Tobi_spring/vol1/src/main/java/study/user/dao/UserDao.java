package study.user.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import study.user.code.StatementStrategy;
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

    public void add(final User user) throws ClassNotFoundException, SQLException {
        class AddStatement implements StatementStrategy {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement pstmt = c.prepareStatement("insert into users (id, name, password) values (?,?,?)");
                pstmt.setString(1, user.getId());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getPassword());
                return pstmt;
            }
        }
        AddStatement st = new AddStatement();
        jdbcContextWithStatementStrategy(st);

    }  public void addLambdaInterClass(final User user) throws ClassNotFoundException, SQLException {

        StatementStrategy st = new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement pstmt = c.prepareStatement("insert into users (id, name, password) values (?,?,?)");
                pstmt.setString(1, user.getId());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getPassword());
                return pstmt;
            }
        };
        jdbcContextWithStatementStrategy(st);

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
            if (pstmt != null) { try { pstmt.close();  } catch (SQLException e) {  } }
            if (con != null) { try {  con.close(); } catch (SQLException e) { }}
        }
    }
    public void deleteAllLambdaInnerClass() throws SQLException, ClassNotFoundException {
        StatementStrategy st = new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                return c.prepareStatement("delete from users");
            }
        };
        jdbcContextWithStatementStrategy(st);
    }

    public int getCount() throws SQLException, ClassNotFoundException {
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

    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException{
        Connection con =null;
        PreparedStatement pstmt = null;

        try{
            con = connectionMaker.makeNewConnection();
            pstmt = stmt.makePreparedStatement(con);

            pstmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally{
            if (pstmt != null) { try { pstmt.close();  } catch (SQLException e) {  } }
            if (con != null) { try {  con.close(); } catch (SQLException e) { }}
        }
    }

}
