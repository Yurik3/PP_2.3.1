package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public interface UserService {
    void add(User user);
    public List getUsers();

    public User findUser(long id);

    public void deleteUser(long id);

    public void editUser(User user);

}