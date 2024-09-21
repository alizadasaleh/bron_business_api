package az.bron.business.feature.servicecategory.domain.service.impl;

import az.bron.business.feature.servicecategory.domain.model.ServiceCategory;
import az.bron.business.feature.servicecategory.domain.repository.ServiceCategoryRepository;
import az.bron.business.feature.servicecategory.domain.service.ServiceCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceCategoryServiceImpl implements ServiceCategoryService {
    private final ServiceCategoryRepository servicecategoryRepository;

    @Override
    public ServiceCategory create(ServiceCategory servicecategory) {
        return servicecategoryRepository.save(servicecategory);
    }

    @Override
    public ServiceCategory update(ServiceCategory servicecategory) {
        return servicecategoryRepository.save(servicecategory);
    }

    @Override
    public Optional<ServiceCategory> get(Integer id) {
        return servicecategoryRepository.findById(id);
    }

    @Override
    public List<ServiceCategory> getAll() {
        return servicecategoryRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
       servicecategoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCoverImageUrl(String fileName, Long id) {
        servicecategoryRepository.insertCoverImageUrl(fileName,id);
    }
}
