package az.bron.business.feature.address.application.facade.impl;

import az.bron.business.feature.address.application.facade.AddressFacade;
import az.bron.business.feature.address.application.mapper.AddressMapper;
import az.bron.business.feature.address.application.model.request.CreateAddressRequest;
import az.bron.business.feature.address.application.model.request.UpdateAddressRequest;
import az.bron.business.feature.address.application.model.response.CreateAddressResponse;
import az.bron.business.feature.address.application.model.response.GetAddressResponse;
import az.bron.business.feature.address.application.model.response.UpdateAddressResponse;
import az.bron.business.feature.address.domain.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class AddressFacadeImpl implements AddressFacade {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @Override
    public CreateAddressResponse create(CreateAddressRequest request) {
        var addressModel = addressMapper.toModel(request);
        var address = addressService.create(addressModel);

        return addressMapper.toCreateResponse(address);
    }

    @Override
    public UpdateAddressResponse update(Long id, UpdateAddressRequest request) {
        var addressModel = addressMapper.toModel(request);

        var existingAddress = addressService.get(id);

        if (existingAddress.isEmpty()) {
            throw new RuntimeException("Address with id " + id + " does not exist");
        }

       addressModel.setId(id);

        var address = addressService.create(addressModel);

        return addressMapper.toUpdateResponse(address);
    }

    @Override
    public GetAddressResponse get(Long id) {
        var existingAddress = addressService.get(id);

        if (existingAddress.isEmpty()) {
            throw new RuntimeException("Address with id " + id + " does not exist");
        }

        var address = existingAddress.get();

        return addressMapper.toGetResponse(address);
    }

    @Override
    public List<GetAddressResponse> getAll() {
        var result = addressService.getAll();

        return result.stream()
                .map(addressMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingAddress = addressService.get(id);

        if (existingAddress.isEmpty()) {
            throw new RuntimeException("Address with id " + id + " does not exist");
        }

       addressService.delete(id);
    }
}
