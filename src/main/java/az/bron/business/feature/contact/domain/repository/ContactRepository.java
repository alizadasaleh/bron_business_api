package az.bron.business.feature.contact.domain.repository;

import az.bron.business.feature.contact.domain.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
