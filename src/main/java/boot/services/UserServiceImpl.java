package boot.services;


import boot.models.User;
import boot.repositories.UserRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl repository;

    public UserServiceImpl(UserRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        repository.add(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        repository.editUser(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
