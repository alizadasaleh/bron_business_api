package az.bron.business.feature.address.infrastructure.persistence;

import az.bron.business.feature.address.domain.repository.AddressRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMyBatisRepository extends AddressRepository {
}