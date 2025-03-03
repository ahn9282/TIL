package study.user.code;

import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public class JdbcContext {


    @Resource
    private DataSource dataSource;

    public JdbcContext(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = this.dataSource.getConnection();
            pstmt = stmt.makePreparedStatement(con);

            pstmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        }finally{
            if (pstmt != null) { try { pstmt.close();  } catch (SQLException e) {  } }
            if (con != null) { try {  con.close(); } catch (SQLException e) { } }
        }
    }


}
