package az.bron.business.feature.address.domain.service.impl;

import az.bron.business.feature.address.domain.model.Address;
import az.bron.business.feature.address.domain.repository.AddressRepository;
import az.bron.business.feature.address.domain.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    final AddressRepository addressRepository;

    @Override
    public void add(Address address) {
        addressRepository.add(address);
    }

    @Override
    public void update(Address address) {
        addressRepository.update(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.delete(id);
    }

    @Override
    public Optional<Address> get(Long id) {
        return addressRepository.get(id);
    }

    @Override
    public Collection<Address> getAll() {
        return addressRepository.getAll();
    }
}

