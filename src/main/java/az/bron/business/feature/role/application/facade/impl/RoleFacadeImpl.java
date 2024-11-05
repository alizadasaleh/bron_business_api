package az.bron.business.feature.role.application.facade.impl;

import az.bron.business.feature.role.application.exception.RoleNotFoundException;
import az.bron.business.feature.role.application.facade.RoleFacade;
import az.bron.business.feature.role.application.mapper.RoleMapper;
import az.bron.business.feature.role.application.model.request.CreateRoleRequest;
import az.bron.business.feature.role.application.model.request.UpdateRoleRequest;
import az.bron.business.feature.role.application.model.response.CreateRoleResponse;
import az.bron.business.feature.role.application.model.response.GetRoleResponse;
import az.bron.business.feature.role.application.model.response.UpdateRoleResponse;
import az.bron.business.feature.role.domain.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class RoleFacadeImpl implements RoleFacade {
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @Override
    public CreateRoleResponse create(CreateRoleRequest request) {
        var roleModel = roleMapper.toModel(request);
        var role = roleService.create(roleModel);

        return roleMapper.toCreateResponse(role);
    }

    @Override
    public UpdateRoleResponse update(Integer id, UpdateRoleRequest request) {
        var roleModel = roleMapper.toModel(request);

        var existingRole = roleService.get(id);

        if (existingRole.isEmpty()) {
            throw new RoleNotFoundException("Role with id " + id + " does not exist");
        }

       roleModel.setId(id);

        var role = roleService.create(roleModel);

        return roleMapper.toUpdateResponse(role);
    }

    @Override
    public GetRoleResponse get(Integer id) {
        var existingRole = roleService.get(id);

        if (existingRole.isEmpty()) {
            throw new RoleNotFoundException("Role with id " + id + " does not exist");
        }

        var role = existingRole.get();

        return roleMapper.toGetResponse(role);
    }

    @Override
    public List<GetRoleResponse> getAll() {
        var result = roleService.getAll();

        return result.stream()
                .map(roleMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Integer id) {
        var existingRole = roleService.get(id);

        if (existingRole.isEmpty()) {
            throw new RoleNotFoundException("Role with id " + id + " does not exist");
        }

       roleService.delete(id);
    }
}
