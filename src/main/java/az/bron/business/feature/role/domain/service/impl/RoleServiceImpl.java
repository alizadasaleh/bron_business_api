package az.bron.business.feature.role.domain.service.impl;

import az.bron.business.feature.role.domain.model.Role;
import az.bron.business.feature.role.domain.model.RoleEnum;
import az.bron.business.feature.role.domain.repository.RoleRepository;
import az.bron.business.feature.role.domain.service.RoleService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> get(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> findByName(RoleEnum roleEnum) {
        return roleRepository.findByName(roleEnum);
    }
}
