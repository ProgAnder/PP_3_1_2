package boot.services;


import boot.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void update(User user);

    void delete(Long id);


}
