package az.bron.business.feature.businessowner.infrastructure.persistence;

import az.bron.business.feature.businessowner.domain.repository.BusinessownerRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessownerMyBatisRepository extends BusinessownerRepository {
}