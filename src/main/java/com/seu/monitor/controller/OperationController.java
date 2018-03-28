package com.seu.monitor.controller;

import com.seu.monitor.config.UserConfig;
import com.seu.monitor.entity.Operation;
import com.seu.monitor.entity.User;
import com.seu.monitor.reposirity.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    @PostMapping(value = "/operation/get_operation_by_user")
    public List<Operation> getOperationByUser(@RequestParam("user_name")String userName, HttpSession session){
        if(!session.getAttribute(UserConfig.USER_POWER).equals(UserConfig.ADMIN)){
            return null;
        }else {
            return operationRepository.findByUserName(userName);
        }
    }

}