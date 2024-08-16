package az.bron.business.feature.providedservice.infrastructure.persistence;

import az.bron.business.feature.providedservice.domain.repository.ProvidedserviceRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProvidedserviceMyBatisRepository extends ProvidedserviceRepository {
}