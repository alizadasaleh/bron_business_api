package az.bron.business.feature.organization.application.facade.impl;

import az.bron.business.feature.organization.application.exception.OrganizationNotFoundException;
import az.bron.business.feature.organization.application.facade.OrganizationFacade;
import az.bron.business.feature.organization.application.mapper.OrganizationMapper;
import az.bron.business.feature.organization.application.model.request.CreateOrganizationRequest;
import az.bron.business.feature.organization.application.model.request.UpdateOrganizationRequest;
import az.bron.business.feature.organization.application.model.response.CreateOrganizationResponse;
import az.bron.business.feature.organization.application.model.response.GetOrganizationResponse;
import az.bron.business.feature.organization.application.model.response.UpdateOrganizationResponse;
import az.bron.business.feature.organization.domain.model.Organization;
import az.bron.business.feature.organization.domain.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class OrganizationFacadeImpl implements OrganizationFacade {
    private final OrganizationService organizationService;

    private final OrganizationMapper organizationMapper;

    @Override
    public CreateOrganizationResponse create(CreateOrganizationRequest request) {
        Organization organization = organizationMapper.toModel(request);
        organizationService.add(organization);

        return organizationMapper.toCreateResponse(organization);
    }

    @Override
    public UpdateOrganizationResponse update(Long id, UpdateOrganizationRequest request) {
        Organization organization = organizationMapper.toModel(request);

        var existingOrganization = organizationService.get(id);

        if (existingOrganization.isEmpty()) {
            throw new OrganizationNotFoundException();
        }

        var organizationId = existingOrganization.get().getId();

        organization.setId(organizationId);

        organizationService.update(organization);

        return organizationMapper.toUpdateResponse(organization);
    }

    @Override
    public List<GetOrganizationResponse> getAll() {
        Collection<Organization> organizations = organizationService.getAll();

        return organizations.stream()
                .map(organizationMapper::toVehicleResponse)
                .toList();
    }

    @Override
    public GetOrganizationResponse get(Long id) {
        var organization = organizationService.get(id);

        if (organization.isEmpty()) {
            throw new OrganizationNotFoundException();
        }

        return organizationMapper.toVehicleResponse(organization.get());
    }

    @Override
    public void delete(Long id) {
        organizationService.delete(id);
    }
}
