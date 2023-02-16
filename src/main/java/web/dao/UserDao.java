package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void add(User user);

    public List <User> getUsers();

    public User findUser(long id);

    public void deleteUser(long id);

    public void editUser(User user);
}
