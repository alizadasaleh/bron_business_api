package az.bron.business.feature.providedservice.domain.specification;

import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public interface ProvidedServiceSpecification {

    static Specification<ProvidedService> withFilters(
            ProvidedServiceFilter filter
    ) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getGender() != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("gender"),
                        filter.getGender()
                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}