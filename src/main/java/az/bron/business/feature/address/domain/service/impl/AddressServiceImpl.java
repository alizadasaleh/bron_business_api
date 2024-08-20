package az.bron.business.feature.address.domain.service.impl;

import az.bron.business.feature.address.domain.model.Address;
import az.bron.business.feature.address.domain.repository.AddressRepository;
import az.bron.business.feature.address.domain.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> get(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       addressRepository.deleteById(id);
    }
}
