package com.bob.test_my_sql.controller;

import com.bob.test_my_sql.entity.User;
import com.bob.test_my_sql.reposirity.UserRepository;
import jdk.nashorn.internal.ir.WhileNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/user/login")
    public String loginTest(@RequestParam("user_name")String userName,
                            @RequestParam("password")String password){

        List<User> userNameSameList = userRepository.findByUserName(userName);
        int index = userNameSameList.size();
        System.out.println("same name user num is " + index);
        User loginUser;
        if(index == 0){

            return "账号错误，请检查账号！";
        }
        while(index > 0){
            index--;
            loginUser = userNameSameList.get(index);
            System.out.println(userName + " password is " + loginUser.getPassword() +", and input is " + password);
            if(loginUser.getPassword().equals(password)){
                return loginUser.getPower() + " login success";
            }
        }
        return "密码错误，请检查密码！";

    }

    @PostMapping(value = "/user/add_user")
    public String addUser(@RequestParam("user_name")String userName,
                          @RequestParam("password")String password,
                          @RequestParam("power")String power){
        if(userRepository.findByUserName(userName).size() > 0){
            return "用户已存在，请更换用户名";
        }else{
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setPower(power);
            userRepository.save(user);
            return "用户添加成功";
        }
    }

    @PostMapping(value = "/user/change_password")
    public String changePassword(@RequestParam("user_name")String userName,
                                 @RequestParam("old_password")String oldPassword,
                                 @RequestParam("new_password")String newPassword){
        List<User> userList = userRepository.findByUserName(userName);
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
        return "Ok";
    }

    @PostMapping(value = "/user/change_power")
    public String modifyPower(@RequestParam("user_name")String userName,
                              @RequestParam("user_power")String userPower){
        List<User> userList = userRepository.findByUserName(userName);
        if(userList.size() == 0){
            return "用户名错误，请检查！";
        }else{
            User user = userList.get(0);
            user.setPower(userPower);
            userRepository.save(user);
            return "用户权限已更改";
        }
    }

    @GetMapping(value = "/user/get_all_user_message")
    public List<User> getAllUserMessage(){
        return userRepository.findAll();
    }

}
