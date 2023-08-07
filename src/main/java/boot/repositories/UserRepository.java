package boot.repositories;


import boot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository {

    void add(User user);

    List<User> findAll();

    User findById(long id);

    void deleteById(long id);

    void editUser(User user);


}
