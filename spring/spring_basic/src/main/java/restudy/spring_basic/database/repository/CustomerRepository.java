package restudy.spring_basic.database.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import restudy.spring_basic.database.object.Customer;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
public class CustomerRepository {

    private final DataSource dataSource;

    public CustomerRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Customer findById(String memberId) throws SQLException {
        String sql = "select * from customer where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Customer customer = new Customer();
                customer.setMember_id(rs.getString("member_id"));
                customer.setMoney(rs.getInt("money"));

                return customer;
            } else {
                throw new NoSuchElementException("customer not found memberId = " + memberId);
            }
        } catch (Exception e) {
            log.error("db error", e);
            throw e;
        }finally {
            close(con, pstmt, rs);
        }
    }


    public List<Customer> findAll() throws SQLException {
        String sql = "SELECT * FROM customer";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Customer> customers = new ArrayList<>();
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setMember_id(rs.getString("member_id"));
                customer.setName(rs.getString("name"));
                customer.setMoney(rs.getInt("money"));
                customers.add(customer);
            }
            return customers;
        } catch (Exception e) {
            log.error("DB error", e);
            throw e;
        } finally {
            close(con, pstmt, rs);
        }
    }

    public void save(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (member_id, name, money) VALUES (?, ?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customer.getMember_id());
            pstmt.setString(2, customer.getName());
            pstmt.setLong(3, customer.getMoney());
            pstmt.executeUpdate();
        } catch (Exception e) {
            log.error("DB error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    public void update(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET name = ?, money = ? WHERE member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customer.getName());
            pstmt.setLong(2, customer.getMoney());
            pstmt.setString(3, customer.getMember_id());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new NoSuchElementException("Customer not found, memberId = " + customer.getMember_id());
            }
        } catch (Exception e) {
            log.error("DB error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    public void delete(String memberId) throws SQLException {
        String sql = "DELETE FROM customer WHERE member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new NoSuchElementException("Customer not found, memberId = " + memberId);
            }
        } catch (Exception e) {
            log.error("DB error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    private Connection getConnection() throws SQLException {
        //트랜잭션 동기화를 할 경우 해당 DataSourceUtils 사용
        Connection con = DataSourceUtils.getConnection(dataSource);
        log.info("get connection : {}", con);
        return con;
    }

    private void close(Connection con, Statement stmt, ResultSet resultSet) throws SQLException {
        JdbcUtils.closeResultSet(resultSet);
        JdbcUtils.closeStatement(stmt);
        //트랜잭션 동기화를 사용시 닫을 때도 DataSourceUtils 사용
        DataSourceUtils.releaseConnection(con, dataSource);

    }
}
