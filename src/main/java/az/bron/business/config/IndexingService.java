package az.bron.business.config;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class IndexingService implements ApplicationListener<ContextRefreshedEvent> {
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void onApplicationEvent(@NonNull ContextRefreshedEvent contextRefreshedEvent) {
        SearchSession searchSession = Search.session(entityManager);
        try {
            searchSession.massIndexer().idFetchSize(80).batchSizeToLoadObjects(15).threadsToLoadObjects(8)
                    .startAndWait();
        } catch (InterruptedException interruptedException) {
            log.error("Mass indexing failed!", interruptedException);
            Thread.currentThread().interrupt();
        }
    }
}