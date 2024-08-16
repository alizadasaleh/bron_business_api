package az.bron.business.feature.contact.domain.repository;

import az.bron.business.feature.contact.domain.model.Contact;
import az.gov.dlp.domain.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}