package az.bron.business.feature.user.application.mapper;

import az.bron.business.feature.user.application.model.request.CreateUserRequest;
import az.bron.business.feature.user.application.model.request.UpdateUserRequest;
import az.bron.business.feature.user.application.model.response.CreateUserResponse;
import az.bron.business.feature.user.application.model.response.GetUserResponse;
import az.bron.business.feature.user.application.model.response.UpdateUserResponse;
import az.bron.business.feature.user.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toModel(CreateUserRequest request);

    User toModel(UpdateUserRequest request);

    CreateUserResponse toCreateResponse(User user);

    UpdateUserResponse toUpdateResponse(User user);

    GetUserResponse toGetResponse(User user);
}
