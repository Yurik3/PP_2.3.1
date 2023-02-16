package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List <User> getUsers() {
        List <User> user = userDao.getUsers();
        return user;
    }

    @Override
    public User findUser(long id) {
        return userDao.findUser(id);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);

    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);

    }
}
