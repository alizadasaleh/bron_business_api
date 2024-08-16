package az.bron.business.feature.organization.domain.service.impl;

import az.bron.business.feature.organization.domain.model.Organization;
import az.bron.business.feature.organization.domain.repository.OrganizationRepository;
import az.bron.business.feature.organization.domain.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    final OrganizationRepository organizationRepository;

    @Override
    public void add(Organization organization) {
        organizationRepository.add(organization);
    }

    @Override
    public void update(Organization organization) {
        organizationRepository.update(organization);
    }

    @Override
    public void delete(Long id) {
        organizationRepository.delete(id);
    }

    @Override
    public Optional<Organization> get(Long id) {
        return organizationRepository.get(id);
    }

    @Override
    public Collection<Organization> getAll() {
        return organizationRepository.getAll();
    }
}

