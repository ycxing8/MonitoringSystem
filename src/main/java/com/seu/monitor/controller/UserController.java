package com.seu.monitor.controller;

import com.seu.monitor.entity.User;
import com.seu.monitor.reposirity.UserRepository;
import com.seu.monitor.config.UserConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/user/login")
    public String loginTest(@RequestParam("name")String name,
                            @RequestParam("password")String password,
                            HttpSession session){

        List<User> userList = userRepository.findByName(name);
        int index = userList.size();
        if(index > 1){
            System.out.println("same name user num is " + index + ";" +
                    "system can't have two same name user!");
            return "该用户存在问题，请联系管理员！";
        }
        if(index == 0){
            return "账号错误，请检查账号！";
        }
        User user = userList.get(index);
        System.out.println(name + " password is " + user.getPassword() +", and input is " + password);
        if(user.getPassword().equals(password)){
            session.setAttribute(UserConfig.USER_POWER, user.getPower());
            session.setAttribute(UserConfig.USER_NAME, user.getName());
            return user.getName() + " login success;" + "you are " + user.getPower();
        }

        return "密码错误，请检查密码！";
    }

    @GetMapping("/user/login_out")
    public String loginOut(HttpSession session){
        session.removeAttribute(UserConfig.USER_POWER);
        session.removeAttribute(UserConfig.USER_NAME);
        return "login out ok!";
    }

    @PostMapping(value = "/user/add_user")
    public String addUser(@RequestParam("name")String name,
                          @RequestParam("password")String password,
                          @RequestParam("power")Integer powerInteger,
                          HttpSession session){
        if(!session.getAttribute(UserConfig.USER_POWER).equals(UserConfig.ADMIN)){
            return "你没有管理员权限！";
        }
        if(userRepository.findByName(name).size() > 0){
            return "用户已存在，请更换用户名！";
        }else{
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setPower(UserConfig.getUserPowerByInteger(powerInteger));
            userRepository.save(user);
            return "用户添加成功！";
        }
    }

    @PostMapping(value = "/user/change_password")
    public String changePassword(@RequestParam("name")String name,
                                 @RequestParam("old_password")String oldPassword,
                                 @RequestParam("new_password")String newPassword,
                                 HttpSession session){
        if(!session.getAttribute(UserConfig.USER_POWER).equals(UserConfig.ADMIN)){
            return "你没有管理员权限！";
        }
        List<User> userList = userRepository.findByName(name);
        if(userList.size() == 0){
            return "用户名不存在，请检查用户名！";
        }else{
            User user = userList.get(0);
            if(user.getPassword().equals(oldPassword)){
                user.setPassword(newPassword);
                userRepository.save(user);
            }else {
                return "原来的密码输入错误，请检查！";
            }
        }
        return "密码修改成功！";
    }

    @PostMapping(value = "/user/change_power")
    public String modifyPower(@RequestParam("name")String name,
                              @RequestParam("power")Integer powerInteger,
                              HttpSession session){

        if(!session.getAttribute(UserConfig.USER_POWER).equals(UserConfig.ADMIN)){
            return "你没有管理员权限！";
        }
        List<User> userList = userRepository.findByName(name);
        if(userList.size() == 0){
            return "用户名错误，请检查！";
        }else{
            User user = userList.get(0);
            user.setPower(UserConfig.getUserPowerByInteger(powerInteger));
            userRepository.save(user);
            return "用户权限已更改！";
        }
    }

    @GetMapping(value = "/user/get_all_user_message")
    public List<User> getAllUserMessage(HttpSession session){
        if(!session.getAttribute(UserConfig.USER_POWER).equals(UserConfig.ADMIN)){
            return null;
        }else {
            return userRepository.findAll();
        }
    }

}
