package az.bron.business.feature.company.application.mapper;

import az.bron.business.feature.company.application.model.request.contact.CreateContactRequest;
import az.bron.business.feature.company.application.model.request.contact.UpdateContactRequest;
import az.bron.business.feature.company.application.model.response.contact.CreateContactResponse;
import az.bron.business.feature.company.application.model.response.contact.GetContactResponse;
import az.bron.business.feature.company.application.model.response.contact.UpdateContactResponse;
import az.bron.business.feature.company.domain.model.contact.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toModel(CreateContactRequest request);

    Contact toModel(UpdateContactRequest request);

    CreateContactResponse toCreateResponse(Contact contact);

    UpdateContactResponse toUpdateResponse(Contact contact);

    GetContactResponse toGetResponse(Contact contact);
}
