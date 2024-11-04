package az.bron.business.feature.user.domain.service;

import az.bron.business.feature.user.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);

    User update(User user);

    Optional<User> get(Long id);

    List<User> getAll();

    void delete(Long id);
}
