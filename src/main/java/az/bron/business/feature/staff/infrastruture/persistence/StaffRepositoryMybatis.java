package az.bron.business.feature.staff.infrastruture.persistence;

import az.bron.business.feature.staff.domain.model.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StaffRepositoryMybatis extends BaseMapper<Staff> {
}
