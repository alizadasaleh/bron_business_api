package az.bron.business.feature.role.application.facade;

import az.bron.business.feature.role.application.model.request.CreateRoleRequest;
import az.bron.business.feature.role.application.model.request.UpdateRoleRequest;
import az.bron.business.feature.role.application.model.response.CreateRoleResponse;
import az.bron.business.feature.role.application.model.response.GetRoleResponse;
import az.bron.business.feature.role.application.model.response.UpdateRoleResponse;
import java.util.List;

public interface RoleFacade {
    CreateRoleResponse create(CreateRoleRequest request);

    UpdateRoleResponse update(Integer id, UpdateRoleRequest request);

    GetRoleResponse get(Integer id);

    List<GetRoleResponse> getAll();

    void delete(Integer id);
}
