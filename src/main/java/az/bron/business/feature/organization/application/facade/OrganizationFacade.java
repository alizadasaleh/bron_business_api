package az.bron.business.feature.organization.application.facade;

import az.bron.business.feature.organization.application.model.request.CreateOrganizationRequest;
import az.bron.business.feature.organization.application.model.request.UpdateOrganizationRequest;
import az.bron.business.feature.organization.application.model.response.CreateOrganizationResponse;
import az.bron.business.feature.organization.application.model.response.GetOrganizationResponse;
import az.bron.business.feature.organization.application.model.response.UpdateOrganizationResponse;

import java.util.List;

public interface OrganizationFacade {
    CreateOrganizationResponse create(CreateOrganizationRequest dto);

    UpdateOrganizationResponse update(Long id, UpdateOrganizationRequest dto);

    List<GetOrganizationResponse> getAll();

    GetOrganizationResponse get(Long id);

    void delete(Long id);
}
