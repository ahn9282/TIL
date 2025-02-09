package study.template_3;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import study.user.domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateUserDao {
    private JdbcTemplate jdbcTemplate;
    private RowMapper userMapper;

    public JdbcTemplateUserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.userMapper = (RowMapper<User>) (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        };
    }

   public void add(User user){
       this.jdbcTemplate.update("insert into users (id, name, password) values (?, ?, ?)", user.getId(), user.getName(), user.getPassword());
   }

   public User get(String id){
       return (User) this.jdbcTemplate.queryForObject("select * from users where id = ?", new Object[]{id}, this.userMapper);
   }

   public void deleteAll(){
       this.jdbcTemplate.update("delete from users ");
   }

   public int getCount(){
       return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
   }

   public List<User> getAll(){
       return this.jdbcTemplate.query("select * from users order by id", this.userMapper);
   }
}
