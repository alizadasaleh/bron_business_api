package az.bron.business.feature.operatinghour.infrastructure.persistence;

import az.bron.business.feature.operatinghour.domain.repository.OperatinghourRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperatinghourMyBatisRepository extends OperatinghourRepository {
}