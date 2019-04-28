package example.service;

import example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public interface UserService {
    public User getUser(String username);

    public int insertUser(User user);

    public List<User> getUsers();
}