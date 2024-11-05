package az.bron.business.feature.user.application.facade.impl;

import az.bron.business.feature.role.domain.model.Role;
import az.bron.business.feature.role.domain.model.RoleEnum;
import az.bron.business.feature.role.domain.repository.RoleRepository;
import az.bron.business.feature.role.domain.service.RoleService;
import az.bron.business.feature.user.application.exception.UserNotFoundException;
import az.bron.business.feature.user.application.facade.UserFacade;
import az.bron.business.feature.user.application.mapper.UserMapper;
import az.bron.business.feature.user.application.model.request.CreateUserRequest;
import az.bron.business.feature.user.application.model.request.UpdateUserRequest;
import az.bron.business.feature.user.application.model.response.CreateUserResponse;
import az.bron.business.feature.user.application.model.response.GetUserResponse;
import az.bron.business.feature.user.application.model.response.UpdateUserResponse;
import az.bron.business.feature.user.domain.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final UserMapper userMapper;
    private final RoleService roleService;

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        Optional<Role> optionalRole = roleService.findByName(request.getRole());

        if (optionalRole.isEmpty()) {
            return null;
        }
        var userModel = userMapper.toModel(request);
        userModel.setRole(optionalRole.get());
        var user = userService.create(userModel);

        return userMapper.toCreateResponse(user);
    }

    @Override
    public UpdateUserResponse update(Long id, UpdateUserRequest request) {
        Optional<Role> optionalRole = roleService.findByName(RoleEnum.ADMIN);

        if (optionalRole.isEmpty()) {
            return null;
        }
        var userModel = userMapper.toModel(request);

        userModel.setRole(optionalRole.get());

        var existingUser = userService.get(id);

        if (existingUser.isEmpty()) {
            throw new UserNotFoundException("User with id " + id + " does not exist");
        }

       userModel.setId(id);

        var user = userService.create(userModel);

        return userMapper.toUpdateResponse(user);
    }

    @Override
    public GetUserResponse get(Long id) {
        var existingUser = userService.get(id);

        if (existingUser.isEmpty()) {
            throw new UserNotFoundException("User with id " + id + " does not exist");
        }

        var user = existingUser.get();

        return userMapper.toGetResponse(user);
    }

    @Override
    public List<GetUserResponse> getAll() {
        var result = userService.getAll();

        return result.stream()
                .map(userMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingUser = userService.get(id);

        if (existingUser.isEmpty()) {
            throw new UserNotFoundException("User with id " + id + " does not exist");
        }

       userService.delete(id);
    }
}
