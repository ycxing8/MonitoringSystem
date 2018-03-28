package com.seu.monitor.controller;

import com.seu.monitor.config.UserConfig;
import com.seu.monitor.entity.Component;
import com.seu.monitor.reposirity.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ComponentController {

    @Autowired
    private ComponentRepository componentRepository;
/*
    @PostMapping(value = "/component/add")
    public String addValue(@RequestParam("code")String code,
                           @RequestParam("machine_identity_code")String machineIdentityCode,
                           @RequestParam("name")String name,
                           @RequestParam("mode")String mode,
                           @RequestParam("dn")String dn,
                           @RequestParam("description")String description,
                           @RequestParam("state")String state,
                           @RequestParam("opening")String opening,
                           HttpSession session){
        if(!session.getAttribute(UserConfig.USER_POWER).equals(UserConfig.ADMIN)){
            return "你没有管理员权限！";
        }
        List<Component> componentList = componentRepository.findByInAndIdentifierAndMachineIdentifier(code);
        if(componentList.size() > 0){
            return "阀门编号已存在，请更换编号！";
        }else{
            component component = new component();
            component.setCode(code);
            component.setMachineIdentityCode(machineIdentityCode);
            component.setName(name);
            component.setMode(mode);
            component.setDn(dn);
            component.setDescription(description);
            component.setState(state);
            component.setOpening(opening);
            componentRepository.save(component);
            return "Ok";
        }
    }

    @PostMapping(value = "/component/modify")
    public String modifyValue(@RequestParam("code")String code,
                           @RequestParam("machine_identity_code")String machineIdentityCode,
                           @RequestParam("name")String name,
                           @RequestParam("mode")String mode,
                           @RequestParam("dn")String dn,
                           @RequestParam("description")String description,
                           @RequestParam("state")String state,
                           @RequestParam("opening")String opening,
                              HttpSession session){
        if(!session.getAttribute(UserConfig.USER_POWER).equals(UserConfig.ADMIN)){
            return "你没有管理员权限！";
        }
        List<component> componentList = componentRepository.findByCode(code);
        if(componentList.size() == 0){
            return "该阀门不已存在，请检查！";
        }else{
            component component = componentList.get(0);
            component.setCode(code);
            component.setMachineIdentityCode(machineIdentityCode);
            component.setName(name);
            component.setMode(mode);
            component.setDn(dn);
            component.setDescription(description);
            component.setState(state);
            component.setOpening(opening);
            componentRepository.save(component);
            return "Ok";
        }
    }
*/
    @GetMapping(value = "/component/get_all")
    public List<Component> getAllComponentMessage(HttpSession session){
       /* if(!session.getAttribute(UserConfig.USER_POWER).equals(UserConfig.ADMIN)){
            return null;
        }*/
       if(!UserConfig.verifyUserPower((String)session.getAttribute(UserConfig.USER_POWER),UserConfig.NORMAL_USER)){
          //user’s power is accord with need power
           return null;
       }
       return componentRepository.findAll();
    }

}
