package az.bron.business.config;

import org.hibernate.Session;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.context.event.ApplicationReadyEvent;

@Component
public class HibernateSearchInitializer {

    @PersistenceContext
    private EntityManager entityManager;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeHibernateSearch() {
        try {
            // Unwrap EntityManager to get the Hibernate Session
            Session session = entityManager.unwrap(Session.class);

            // Access the Search session and perform mass indexing
            Search.session(session)
                    .massIndexer()
                    .startAndWait();

            System.out.println("Hibernate Search indexes initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
