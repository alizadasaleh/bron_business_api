package az.bron.business.feature.contact.application.facade;

import az.bron.business.feature.contact.application.model.request.CreateContactRequest;
import az.bron.business.feature.contact.application.model.request.UpdateContactRequest;
import az.bron.business.feature.contact.application.model.response.CreateContactResponse;
import az.bron.business.feature.contact.application.model.response.GetContactResponse;
import az.bron.business.feature.contact.application.model.response.UpdateContactResponse;

import java.util.List;

public interface ContactFacade {
    CreateContactResponse create(CreateContactRequest dto);

    UpdateContactResponse update(Long id, UpdateContactRequest dto);

    List<GetContactResponse> getAll();

    GetContactResponse get(Long id);

    void delete(Long id);
}
