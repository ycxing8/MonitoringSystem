package com.bob.test_my_sql.controller;

import com.bob.test_my_sql.entity.Machine;
import com.bob.test_my_sql.reposirity.MachineRepository;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MachineController {

    @Autowired
    private MachineRepository machineRepository;

    @PostMapping(value = "/machine/add_machine")
    public String addMachine(@RequestParam("machine_name")String machineName,
                             @RequestParam("machine_identity_code")String machineIdentityCode,
                             @RequestParam("machine_place")String machinePlace,
                             @RequestParam("machine_description")String machineDescription){
        if(machineRepository.findByMachineIdentityCode(machineIdentityCode).size() > 0) {
            return "Identity code already exist, please change another";
        }else{
            Machine machine = new Machine();
            machine.setMachineName(machineName);
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
                                @RequestParam("machine_state")String machineState){
        List<Machine> machinesList = machineRepository.findByMachineIdentityCode(machineIdentityCode);
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
    }

    @GetMapping(value = "/machine/get_all_machine_message")
    public List<Machine> getAllMachineMessage(){
       return machineRepository.findAll();
    }

}
