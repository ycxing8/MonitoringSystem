package com.seu.monitor.controller;

import com.seu.monitor.entity.ComponentLog;
import com.seu.monitor.repository.ComponentLogRepository;
import com.seu.monitor.config.UserConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ComponentLogController {

    @Autowired
    private ComponentLogRepository componentLogRepository;

    @PostMapping(value = "/component_log/get_component_log")
    public List<ComponentLog> getComponentLog(@RequestParam("component_identifier")String componentIdentifier,
                                              @RequestParam("machine_identifier")String machineIdentifier,
                                              HttpSession session){
        if(!session.getAttribute(UserConfig.USER_POWER).equals(UserConfig.ADMIN)){
            return null;
        }else {
            return componentLogRepository.findByMachineIdentifierAndComponentIdentifier(machineIdentifier,componentIdentifier);
        }
    }

}
