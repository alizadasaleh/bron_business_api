package az.bron.business.feature.contact.application.facade;

import az.bron.business.feature.contact.application.model.request.CreateContactRequest;
import az.bron.business.feature.contact.application.model.request.UpdateContactRequest;
import az.bron.business.feature.contact.application.model.response.CreateContactResponse;
import az.bron.business.feature.contact.application.model.response.GetContactResponse;
import az.bron.business.feature.contact.application.model.response.UpdateContactResponse;

import java.util.List;

public interface ContactFacade {
    CreateContactResponse create(CreateContactRequest request);

    UpdateContactResponse update(Long id, UpdateContactRequest request);

    GetContactResponse get(Long id);

    List<GetContactResponse> getAll();

    void delete(Long id);
}
