package az.bron.business.feature.contact.application.mapper;

import az.bron.business.feature.contact.application.model.request.CreateContactRequest;
import az.bron.business.feature.contact.application.model.request.UpdateContactRequest;
import az.bron.business.feature.contact.application.model.response.CreateContactResponse;
import az.bron.business.feature.contact.application.model.response.GetContactResponse;
import az.bron.business.feature.contact.application.model.response.UpdateContactResponse;
import az.bron.business.feature.contact.domain.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "address.id", source = "addressId")
    Contact toModel(CreateContactRequest request);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "address.id", source = "addressId")
    Contact toModel(UpdateContactRequest request);

    @Mapping(source = "address.id", target = "addressId")
    CreateContactResponse toCreateResponse(Contact contact);

    @Mapping(source = "address.id", target = "addressId")
    UpdateContactResponse toUpdateResponse(Contact contact);

    GetContactResponse toVehicleResponse(Contact contact);
}