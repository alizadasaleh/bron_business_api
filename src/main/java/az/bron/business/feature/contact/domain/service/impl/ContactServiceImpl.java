package az.bron.business.feature.contact.domain.service.impl;

import az.bron.business.feature.contact.domain.model.Contact;
import az.bron.business.feature.contact.domain.repository.ContactRepository;
import az.bron.business.feature.contact.domain.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    final ContactRepository contactRepository;

    @Override
    public void add(Contact contact) {
        contactRepository.add(contact);
    }

    @Override
    public void update(Contact contact) {
        contactRepository.update(contact);
    }

    @Override
    public void delete(Long id) {
        contactRepository.delete(id);
    }

    @Override
    public Optional<Contact> get(Long id) {
        return contactRepository.get(id);
    }

    @Override
    public Collection<Contact> getAll() {
        return contactRepository.getAll();
    }
}

