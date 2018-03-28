package com.seu.monitor.controller;

import com.seu.monitor.config.UserConfig;
import com.seu.monitor.entity.Machine;
import com.seu.monitor.reposirity.MachineRepository;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MachineController {

    @Autowired
    private MachineRepository machineRepository;
/*
    @PostMapping(value = "/machine/add_machine")
    public String addMachine(
							 @RequestParam("identifier")String identifier,
							 @RequestParam("name")String name, 
                             @RequestParam("place")String place,
                             @RequestParam("description")String description,
                             HttpSession session){
        if(UserConfig.verifyUserPower((String)session.getAttribute(UserConfig.USER_POWER),
                UserConfig.ADMIN)){
            return "你没有权限！";
        }
        if(machineRepository.findByIdentifier(identifier).size() > 0) {
            return "Identity code already exist, please change another";
        }else{
            Machine machine = new Machine();
            machine.setName(name);
            machine.setMachineIdentityCode(machineIdentityCode);
            machine.setMachinePlace(machinePlace);
            machine.setMachineDescription(machineDescription);
            machineRepository.save(machine);
            return "Add machine success";
        }
    }

    @PostMapping(value = "/machine/modify_machine")
    public String modifyMachine(@RequestParam("machine_name")String machineName,
                                @RequestParam("machine_identity_code")String machineIdentityCode,
                                @RequestParam("machine_place")String machinePlace,
                                @RequestParam("machine_description")String machineDescription,
                                @RequestParam("machine_state")String machineState,
                                HttpSession session){

        if(UserConfig.verifyUserPower((String)session.getAttribute(UserConfig.USER_POWER),
                UserConfig.SPECIAL_USER)){
            return "你没有权限！";
        }
        List<Machine> machinesList = machineRepository.findByIdentifier(machineIdentityCode);
        if(machinesList.size() == 0) {
            return "Not have this machine!";
        }else{
            Machine machine = machinesList.get(0);
            machine.setMachineName(machineName);
            machine.setMachineIdentityCode(machineIdentityCode);
            machine.setMachinePlace(machinePlace);
            machine.setMachineDescription(machineDescription);
            machine.setMachineState(machineState);
            machineRepository.save(machine);
            return "Modify machine success!";
        }
    }*/

    @GetMapping(value = "/machine/get_all_message")
    public List<Machine> getAllMessage(HttpSession session){
        if(!UserConfig.verifyUserPower((String)session.getAttribute(UserConfig.USER_POWER),
                UserConfig.NORMAL_USER)){
            return null;
        }else{
            return machineRepository.findAll();
        }
    }

}
