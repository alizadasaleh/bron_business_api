package az.bron.business.feature.address.application.facade.impl;

import az.bron.business.feature.address.application.exception.AddressNotFoundException;
import az.bron.business.feature.address.application.facade.AddressFacade;
import az.bron.business.feature.address.application.mapper.AddressMapper;
import az.bron.business.feature.address.application.model.request.CreateAddressRequest;
import az.bron.business.feature.address.application.model.request.UpdateAddressRequest;
import az.bron.business.feature.address.application.model.response.CreateAddressResponse;
import az.bron.business.feature.address.application.model.response.GetAddressResponse;
import az.bron.business.feature.address.application.model.response.UpdateAddressResponse;
import az.bron.business.feature.address.domain.model.Address;
import az.bron.business.feature.address.domain.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class AddressFacadeImpl implements AddressFacade {
    private final AddressService addressService;

    private final AddressMapper addressMapper;

    @Override
    public CreateAddressResponse create(CreateAddressRequest request) {
        Address address = addressMapper.toModel(request);
        addressService.add(address);

        return addressMapper.toCreateResponse(address);
    }

    @Override
    public UpdateAddressResponse update(Long id, UpdateAddressRequest request) {
        Address address = addressMapper.toModel(request);

        var existingAddress = addressService.get(id);

        if (existingAddress.isEmpty()) {
            throw new AddressNotFoundException();
        }

        var addressId = existingAddress.get().getId();

        address.setId(addressId);

        addressService.update(address);

        return addressMapper.toUpdateResponse(address);
    }

    @Override
    public List<GetAddressResponse> getAll() {
        Collection<Address> addresss = addressService.getAll();

        return addresss.stream()
                .map(addressMapper::toVehicleResponse)
                .toList();
    }

    @Override
    public GetAddressResponse get(Long id) {
        var address = addressService.get(id);

        if (address.isEmpty()) {
            throw new AddressNotFoundException();
        }

        return addressMapper.toVehicleResponse(address.get());
    }

    @Override
    public void delete(Long id) {
        addressService.delete(id);
    }
}
