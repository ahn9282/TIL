package example.springbatch.batch.custom;

import example.springbatch.entity.BeforeEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomBeforeRowMapper implements RowMapper<BeforeEntity> {
    @Override
    public BeforeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
