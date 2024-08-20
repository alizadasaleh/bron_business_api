package az.bron.business.feature.address.application.facade;

import az.bron.business.feature.address.application.model.request.CreateAddressRequest;
import az.bron.business.feature.address.application.model.request.UpdateAddressRequest;
import az.bron.business.feature.address.application.model.response.CreateAddressResponse;
import az.bron.business.feature.address.application.model.response.GetAddressResponse;
import az.bron.business.feature.address.application.model.response.UpdateAddressResponse;

import java.util.List;

public interface AddressFacade {
    CreateAddressResponse create(CreateAddressRequest request);

    UpdateAddressResponse update(Long id, UpdateAddressRequest request);

    GetAddressResponse get(Long id);

    List<GetAddressResponse> getAll();

    void delete(Long id);
}
