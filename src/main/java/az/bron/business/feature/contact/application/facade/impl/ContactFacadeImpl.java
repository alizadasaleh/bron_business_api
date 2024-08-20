package az.bron.business.feature.contact.application.facade.impl;

import az.bron.business.feature.contact.application.facade.ContactFacade;
import az.bron.business.feature.contact.application.mapper.ContactMapper;
import az.bron.business.feature.contact.application.model.request.CreateContactRequest;
import az.bron.business.feature.contact.application.model.request.UpdateContactRequest;
import az.bron.business.feature.contact.application.model.response.CreateContactResponse;
import az.bron.business.feature.contact.application.model.response.GetContactResponse;
import az.bron.business.feature.contact.application.model.response.UpdateContactResponse;
import az.bron.business.feature.contact.domain.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ContactFacadeImpl implements ContactFacade {
    private final ContactService contactService;
    private final ContactMapper contactMapper;

    @Override
    public CreateContactResponse create(CreateContactRequest request) {
        var contactModel = contactMapper.toModel(request);
        var contact = contactService.create(contactModel);

        return contactMapper.toCreateResponse(contact);
    }

    @Override
    public UpdateContactResponse update(Long id, UpdateContactRequest request) {
        var contactModel = contactMapper.toModel(request);

        var existingContact = contactService.get(id);

        if (existingContact.isEmpty()) {
            throw new RuntimeException("Contact with id " + id + " does not exist");
        }

       contactModel.setId(id);

        var contact = contactService.create(contactModel);

        return contactMapper.toUpdateResponse(contact);
    }

    @Override
    public GetContactResponse get(Long id) {
        var existingContact = contactService.get(id);

        if (existingContact.isEmpty()) {
            throw new RuntimeException("Contact with id " + id + " does not exist");
        }

        var contact = existingContact.get();

        return contactMapper.toGetResponse(contact);
    }

    @Override
    public List<GetContactResponse> getAll() {
        var result = contactService.getAll();

        return result.stream()
                .map(contactMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingContact = contactService.get(id);

        if (existingContact.isEmpty()) {
            throw new RuntimeException("Contact with id " + id + " does not exist");
        }

       contactService.delete(id);
    }
}
