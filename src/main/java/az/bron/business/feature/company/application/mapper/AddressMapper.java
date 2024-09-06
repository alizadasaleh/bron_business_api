package az.bron.business.feature.company.application.mapper;

import az.bron.business.feature.company.application.model.request.address.CreateAddressRequest;
import az.bron.business.feature.company.application.model.request.address.UpdateAddressRequest;
import az.bron.business.feature.company.application.model.response.address.CreateAddressResponse;
import az.bron.business.feature.company.application.model.response.address.GetAddressResponse;
import az.bron.business.feature.company.application.model.response.address.UpdateAddressResponse;
import az.bron.business.feature.company.domain.model.address.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toModel(CreateAddressRequest request);

    Address toModel(UpdateAddressRequest request);

    CreateAddressResponse toCreateResponse(Address address);

    UpdateAddressResponse toUpdateResponse(Address address);

    GetAddressResponse toGetResponse(Address address);
}
