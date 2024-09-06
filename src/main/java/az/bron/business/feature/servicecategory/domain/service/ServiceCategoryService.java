package az.bron.business.feature.servicecategory.domain.service;

import az.bron.business.feature.servicecategory.domain.model.ServiceCategory;

import java.util.List;
import java.util.Optional;

public interface ServiceCategoryService {
    ServiceCategory create(ServiceCategory servicecategory);

    ServiceCategory update(ServiceCategory servicecategory);

    Optional<ServiceCategory> get(Integer id);

    List<ServiceCategory> getAll();

    void delete(Integer id);
}
