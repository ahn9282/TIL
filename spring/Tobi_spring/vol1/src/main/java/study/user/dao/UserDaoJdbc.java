package study.user.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import study.user.domain.User;
import study.user.code.Level;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoJdbc implements UserDaoInterface {

    private final JdbcTemplate jdbcTemplate;

    public UserDaoJdbc(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String INSERT_USER =  "INSERT INTO users(id, name, password, level, login, recommend) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String UPDATE_USER = "UPDATE users SET name = ?, password = ?, level = ?, login = ?, recommend = ? WHERE id = ?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    private static final String DELETE_ALL_USERS = "DELETE FROM users";

    @Override
    public void add( User user) {
        this.jdbcTemplate.update(INSERT_USER,
                user.getId(), user.getName(), user.getPassword(),
                user.getLevel().getValue(), user.getLogin(), user.getRecommend());
    }
    @Override
    public User findById(String id) {
        return this.jdbcTemplate.query(SELECT_USER_BY_ID, new UserRowMapper(), id)
                .stream().findFirst().orElse(null);
    }
    @Override
    public void update( User user) {
        this.jdbcTemplate.update(UPDATE_USER,
                user.getName(), user.getPassword(), user.getLevel().getValue(),
                user.getLogin(), user.getRecommend(), user.getId());
    }
    @Override
    public void deleteById(String id) {
        this.jdbcTemplate.update(DELETE_USER_BY_ID, id);
    }
    @Override
    public void deleteAll() {
        this.jdbcTemplate.update(DELETE_ALL_USERS);
    }

    @Override
    public List<User> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return User.builder()
                    .id(rs.getString("id"))
                    .name(rs.getString("name"))
                    .password(rs.getString("password"))
                    .level(Level.valueOf(rs.getInt("level")))
                    .login(rs.getInt("login"))
                    .recommend(rs.getInt("recommend"))
                    .build();
        }
    }
}
