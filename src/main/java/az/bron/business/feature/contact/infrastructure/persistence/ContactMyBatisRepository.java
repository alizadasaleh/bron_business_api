package az.bron.business.feature.contact.infrastructure.persistence;

import az.bron.business.feature.contact.domain.repository.ContactRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactMyBatisRepository extends ContactRepository {
}