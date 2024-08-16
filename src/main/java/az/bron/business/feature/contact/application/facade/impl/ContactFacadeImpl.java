package az.bron.business.feature.contact.application.facade.impl;

import az.bron.business.feature.contact.application.exception.ContactNotFoundException;
import az.bron.business.feature.contact.application.facade.ContactFacade;
import az.bron.business.feature.contact.application.mapper.ContactMapper;
import az.bron.business.feature.contact.application.model.request.CreateContactRequest;
import az.bron.business.feature.contact.application.model.request.UpdateContactRequest;
import az.bron.business.feature.contact.application.model.response.CreateContactResponse;
import az.bron.business.feature.contact.application.model.response.GetContactResponse;
import az.bron.business.feature.contact.application.model.response.UpdateContactResponse;
import az.bron.business.feature.contact.domain.model.Contact;
import az.bron.business.feature.contact.domain.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ContactFacadeImpl implements ContactFacade {
    private final ContactService contactService;

    private final ContactMapper contactMapper;

    @Override
    public CreateContactResponse create(CreateContactRequest request) {
        Contact contact = contactMapper.toModel(request);
        contactService.add(contact);

        return contactMapper.toCreateResponse(contact);
    }

    @Override
    public UpdateContactResponse update(Long id, UpdateContactRequest request) {
        Contact contact = contactMapper.toModel(request);

        var existingContact = contactService.get(id);

        if (existingContact.isEmpty()) {
            throw new ContactNotFoundException();
        }

        var contactId = existingContact.get().getId();

        contact.setId(contactId);

        contactService.update(contact);

        return contactMapper.toUpdateResponse(contact);
    }

    @Override
    public List<GetContactResponse> getAll() {
        Collection<Contact> contacts = contactService.getAll();

        return contacts.stream()
                .map(contactMapper::toVehicleResponse)
                .toList();
    }

    @Override
    public GetContactResponse get(Long id) {
        var contact = contactService.get(id);

        if (contact.isEmpty()) {
            throw new ContactNotFoundException();
        }

        return contactMapper.toVehicleResponse(contact.get());
    }

    @Override
    public void delete(Long id) {
        contactService.delete(id);
    }
}
