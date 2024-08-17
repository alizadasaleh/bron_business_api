package az.bron.business.feature.providedservice.infrastructure.persistence;

import az.bron.business.feature.providedservice.domain.repository.ProvidedServiceRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProvidedServiceMyBatisRepository extends ProvidedServiceRepository {
}