package study.user.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.config.DataSourceConfig;
import study.template_3.JdbcTemplateUserDao;
import study.user.dao.UserDaoWithJdbcContext;
import study.user.domain.User;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Import(DataSourceConfig.class)
public class Chapter4Test {
    @Mock
    DataSource dataSource;
    JdbcTemplateUserDao dao = new JdbcTemplateUserDao(dataSource);

    @Test
    public void sqlExceptionTranslate() throws SQLException, ClassNotFoundException {
        dao.deleteAll();
        User user = new User();
        user.setId("1234");
        user.setName("testUser");
        user.setPassword("2222");

        try {
            dao.add(user);
            dao.add(user);
        } catch (DuplicateKeyException e) {
            SQLException sqlException = (SQLException) e.getRootCause();
            SQLErrorCodeSQLExceptionTranslator translator = new SQLErrorCodeSQLExceptionTranslator(this.dataSource);

            // Corrected assertion
            assertThat(translator.translate(null, null, sqlException))
                    .isInstanceOf(DuplicateKeyException.class); // Check for correct exception type
        }
    }
}
