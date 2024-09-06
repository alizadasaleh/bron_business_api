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
    Contact toModel(CreateContactRequest request);

    Contact toModel(UpdateContactRequest request);

    CreateContactResponse toCreateResponse(Contact contact);

    UpdateContactResponse toUpdateResponse(Contact contact);

    GetContactResponse toGetResponse(Contact contact);
}
