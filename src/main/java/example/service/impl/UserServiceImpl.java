package example.service.impl;

import example.dao.UserMapper;
import example.model.User;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username){
        return userMapper.getUser(username);
    }

    @Override
    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    public List<User> getUsers(){
        return userMapper.getUsers();
    }
}