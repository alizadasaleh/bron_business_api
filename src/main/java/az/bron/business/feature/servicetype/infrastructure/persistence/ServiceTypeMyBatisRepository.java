package az.bron.business.feature.servicetype.infrastructure.persistence;

import az.bron.business.feature.servicetype.domain.repository.ServiceTypeRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServiceTypeMyBatisRepository extends ServiceTypeRepository {
}