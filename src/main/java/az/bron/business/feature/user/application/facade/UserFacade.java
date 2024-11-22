package az.bron.business.feature.user.application.facade;

import az.bron.business.feature.user.application.model.request.CreateUserRequest;
import az.bron.business.feature.user.application.model.request.UpdateUserRequest;
import az.bron.business.feature.user.application.model.response.CreateUserResponse;
import az.bron.business.feature.user.application.model.response.GetUserResponse;
import az.bron.business.feature.user.application.model.response.UpdateUserResponse;
import java.util.List;

public interface UserFacade {
    CreateUserResponse create(CreateUserRequest request);

    UpdateUserResponse update(Long id, UpdateUserRequest request);

    GetUserResponse get(Long id);

    List<GetUserResponse> getAll();

    void delete(Long id);
}
