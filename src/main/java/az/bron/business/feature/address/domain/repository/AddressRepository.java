package az.bron.business.feature.address.domain.repository;

import az.bron.business.feature.address.domain.model.Address;
import az.gov.dlp.domain.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}