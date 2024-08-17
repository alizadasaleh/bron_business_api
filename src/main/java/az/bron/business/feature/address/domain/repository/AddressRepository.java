package az.bron.business.feature.address.domain.repository;

import az.bron.business.feature.address.domain.model.Address;
import az.bron.domain.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}