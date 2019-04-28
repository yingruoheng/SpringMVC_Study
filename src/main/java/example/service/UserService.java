package example.service;

import example.model.User;;

import java.util.List;

public interface UserService {
    public User getUser(String username);

    public int insertUser(User user);

    public List<User> getUsers();
}