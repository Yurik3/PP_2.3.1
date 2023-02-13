package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);

    }

    public List getUsers() {
        List user = entityManager.createQuery("SELECT user from User user ").getResultList();
        return user;
    }

    @Override
    public User findUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(findUser(id));

    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);

    }
}
