package az.bron.business.feature.contact.infrastructure.persistence;

import az.bron.business.feature.contact.domain.model.Schedule;
import az.bron.business.feature.contact.domain.repository.ContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public interface ContactMyBatisRepository extends ContactRepository {
}