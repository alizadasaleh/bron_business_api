package az.bron.business.feature.user.domain.service.impl;

import az.bron.business.feature.user.domain.model.User;
import az.bron.business.feature.user.domain.repository.UserRepository;
import az.bron.business.feature.user.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       userRepository.deleteById(id);
    }
}
