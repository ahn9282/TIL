package study.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class V1ConnectionMaker implements ConnectionMaker {
     private Connection con;
     public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
          Class.forName("com.mysql.jdbc.Driver");

          Connection con = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/spring_tobi?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul",
                  "root", "321tiger");
          return con;
     }

     public V1ConnectionMaker() {
     }

     public V1ConnectionMaker(Connection con) {
          this.con = con;
     }
}
