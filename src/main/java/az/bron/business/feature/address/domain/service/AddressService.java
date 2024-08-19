package az.bron.business.feature.address.domain.service;

import az.bron.business.feature.address.domain.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address create(Address address);

    Address update(Address address);

    Optional<Address> get(Long id);

    List<Address> getAll();

    void delete(Long id);
}
