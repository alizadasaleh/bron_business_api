package az.bron.business.feature.address.application.mapper;

import az.bron.business.feature.address.application.model.request.CreateAddressRequest;
import az.bron.business.feature.address.application.model.request.UpdateAddressRequest;
import az.bron.business.feature.address.application.model.response.CreateAddressResponse;
import az.bron.business.feature.address.application.model.response.GetAddressResponse;
import az.bron.business.feature.address.application.model.response.UpdateAddressResponse;
import az.bron.business.feature.address.domain.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toModel(CreateAddressRequest request);

    Address toModel(UpdateAddressRequest request);

    CreateAddressResponse toCreateResponse(Address address);

    UpdateAddressResponse toUpdateResponse(Address address);

    GetAddressResponse toGetResponse(Address address);
}
