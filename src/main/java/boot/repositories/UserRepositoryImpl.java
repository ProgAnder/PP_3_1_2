package boot.repositories;

import boot.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findById(long id) {
                return entityManager.find(User.class, id);
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(findById(id));

    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);

    }


   










    /*  
    
 *
 public void add(User user);
    public List<User> getList();
    public User getUser(long id);
    public void deleteUser(long id);
    public void editUser(User user);


 *
 * */

}
