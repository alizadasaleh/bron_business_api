package az.bron.business.feature.company.infrastructure.persistence;

import az.bron.business.feature.company.domain.repository.CompanyRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMyBatisRepository extends CompanyRepository {
}