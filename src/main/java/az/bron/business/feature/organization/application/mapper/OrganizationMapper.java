package az.bron.business.feature.organization.application.mapper;

import az.bron.business.feature.organization.application.model.request.CreateOrganizationRequest;
import az.bron.business.feature.organization.application.model.request.UpdateOrganizationRequest;
import az.bron.business.feature.organization.application.model.response.CreateOrganizationResponse;
import az.bron.business.feature.organization.application.model.response.GetOrganizationResponse;
import az.bron.business.feature.organization.application.model.response.UpdateOrganizationResponse;
import az.bron.business.feature.organization.domain.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    Organization toModel(CreateOrganizationRequest request);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    Organization toModel(UpdateOrganizationRequest request);

    CreateOrganizationResponse toCreateResponse(Organization organization);

    UpdateOrganizationResponse toUpdateResponse(Organization organization);

    GetOrganizationResponse toVehicleResponse(Organization organization);
}