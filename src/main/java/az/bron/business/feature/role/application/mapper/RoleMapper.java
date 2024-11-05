package az.bron.business.feature.role.application.mapper;

import az.bron.business.feature.role.application.model.request.CreateRoleRequest;
import az.bron.business.feature.role.application.model.request.UpdateRoleRequest;
import az.bron.business.feature.role.application.model.response.CreateRoleResponse;
import az.bron.business.feature.role.application.model.response.GetRoleResponse;
import az.bron.business.feature.role.application.model.response.UpdateRoleResponse;
import az.bron.business.feature.role.domain.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toModel(CreateRoleRequest request);

    Role toModel(UpdateRoleRequest request);

    CreateRoleResponse toCreateResponse(Role role);

    UpdateRoleResponse toUpdateResponse(Role role);

    GetRoleResponse toGetResponse(Role role);
}
