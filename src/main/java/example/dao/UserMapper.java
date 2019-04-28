package example.dao;

import example.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    public User getUser(String username);

    public int insertUser(User user);

    public List<User> getUsers();
}