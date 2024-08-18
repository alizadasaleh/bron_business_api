package az.bron.business.feature.contact.infrastructure.persistence;

import az.bron.business.feature.contact.domain.model.Schedule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleTypeHandler extends BaseTypeHandler<Schedule> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Schedule schedule, JdbcType jdbcType) throws SQLException {
        ps.setString(i, toJson(schedule));
    }

    @Override
    public Schedule getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String json = rs.getString(columnName);
        return fromJson(json);
    }

    @Override
    public Schedule getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String json = rs.getString(columnIndex);
        return fromJson(json);
    }

    @Override
    public Schedule getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String json = cs.getString(columnIndex);
        return fromJson(json);
    }

    private String toJson(Schedule schedule) {
        try {
            return objectMapper.writeValueAsString(schedule);
        } catch (Exception e) {
            throw new RuntimeException("Error converting Schedule to JSON", e);
        }
    }

    private Schedule fromJson(String json) {
        try {
            return objectMapper.readValue(json, Schedule.class);
        } catch (Exception e) {
            throw new RuntimeException("Error converting JSON to Schedule", e);
        }
    }
}
