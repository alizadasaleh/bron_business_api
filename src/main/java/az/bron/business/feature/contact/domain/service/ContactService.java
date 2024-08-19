package az.bron.business.feature.contact.domain.service;

import az.bron.business.feature.contact.domain.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact create(Contact contact);

    Contact update(Contact contact);

    Optional<Contact> get(Long id);

    List<Contact> getAll();

    void delete(Long id);
}
