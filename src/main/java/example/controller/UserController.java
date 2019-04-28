package example.controller;

import example.dao.UserMapper;
import example.model.ReturnBean;
import example.model.User;
import example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserMapper.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    //用户名密码登录接口
    public ReturnBean singup(String username) {
        logger.info("username{}", username);
        ReturnBean returnBean = new ReturnBean();
        User user = new User();
        user = userService.getUser(username);
        if(user == null){
            returnBean.setRetVal(101);
            returnBean.setRetMsg("用户名或密码错误");
            return returnBean;
        }
        returnBean.setRetBean(user);
        return returnBean;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    //用户注册接口
    public ReturnBean register(@RequestBody String param) {
        logger.info("param{}", param);
        ReturnBean returnBean = new ReturnBean();

        com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();

        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(param);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        int permission = Integer.parseInt(jsonObject.getString("permission"));

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPermission(permission);
        int insertResult = userService.insertUser(user);
        if( insertResult == 1){
            object.put("result", "注册成功");
        }else {
            object.put("result", "注册失败");
        }
        returnBean.setRetBean(object);
        return returnBean;
    }


    @RequestMapping(value = "/users")
    @ResponseBody
    //获取所有用户
    public ReturnBean getUsers() {
        ReturnBean returnBean = new ReturnBean();
        List<User> users = userService.getUsers();
        returnBean.setRetBean(users);
        return returnBean;
    }
}