package az.bron.business.feature.contact.domain.service.impl;

import az.bron.business.feature.contact.domain.model.Contact;
import az.bron.business.feature.contact.domain.repository.ContactRepository;
import az.bron.business.feature.contact.domain.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> get(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       contactRepository.deleteById(id);
    }
}
