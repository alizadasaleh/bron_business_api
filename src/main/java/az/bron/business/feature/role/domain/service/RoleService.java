package az.bron.business.feature.role.domain.service;

import az.bron.business.feature.role.domain.model.Role;

import az.bron.business.feature.role.domain.model.RoleEnum;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role create(Role role);

    Role update(Role role);

    Optional<Role> get(Integer id);

    List<Role> getAll();

    void delete(Integer id);

    Optional<Role> findByName(RoleEnum roleEnum);
}
