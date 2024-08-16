package az.bron.business.feature.organization.infrastructure.persistence;

import az.bron.business.feature.organization.domain.repository.OrganizationRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizationMyBatisRepository extends OrganizationRepository {
}