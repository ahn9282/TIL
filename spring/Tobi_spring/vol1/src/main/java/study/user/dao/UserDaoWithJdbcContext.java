package study.user.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import study.user.code.JdbcContext;
import study.user.code.StatementStrategy;
import study.user.domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDaoWithJdbcContext {
    private JdbcContext jdbcContext;

    public UserDaoWithJdbcContext(DataSource datSource) {

        this.jdbcContext = new JdbcContext(datSource);
    }

    public void add(final User user) throws  SQLException {
        this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement pstmt = c.prepareStatement("insert into users (id, name, password) values (?,?,?)");
                pstmt.setString(1, user.getId());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getPassword());
                return pstmt;
            }
        });

    }

    public User get(String id) throws  SQLException {
        Connection con =jdbcContext.getDataSource().getConnection();
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
        executeSql("delete from users");

    }

    private void executeSql(final String query) throws SQLException{
        this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                return c.prepareStatement(query);
            }
        });
    }

    //etc...

}
