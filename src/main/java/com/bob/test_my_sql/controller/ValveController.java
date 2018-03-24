package com.bob.test_my_sql.controller;

import com.bob.test_my_sql.entity.Valve;
import com.bob.test_my_sql.reposirity.ValveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ValveController {
    @Autowired
    private ValveRepository valveRepository;

    @PostMapping(value = "/valve/add")
    public String addValue(@RequestParam("code")String code,
                           @RequestParam("machine_identity_code")String machineIdentityCode,
                           @RequestParam("name")String name,
                           @RequestParam("mode")String mode,
                           @RequestParam("dn")String dn,
                           @RequestParam("description")String description,
                           @RequestParam("state")String state,
                           @RequestParam("opening")String opening){
        List<Valve> valveList = valveRepository.findByCode(code);
        if(valveList.size() > 0){
            return "阀门编号已存在，请更换编号！";
        }else{
            Valve valve = new Valve();
            valve.setCode(code);
            valve.setMachineIdentityCode(machineIdentityCode);
            valve.setName(name);
            valve.setMode(mode);
            valve.setDn(dn);
            valve.setDescription(description);
            valve.setState(state);
            valve.setOpening(opening);
            valveRepository.save(valve);
            return "Ok";
        }
    }

    @PostMapping(value = "/valve/modify")
    public String modifyValue(@RequestParam("code")String code,
                           @RequestParam("machine_identity_code")String machineIdentityCode,
                           @RequestParam("name")String name,
                           @RequestParam("mode")String mode,
                           @RequestParam("dn")String dn,
                           @RequestParam("description")String description,
                           @RequestParam("state")String state,
                           @RequestParam("opening")String opening){
        List<Valve> valveList = valveRepository.findByCode(code);
        if(valveList.size() == 0){
            return "该阀门不已存在，请检查！";
        }else{
            Valve valve = valveList.get(0);
            valve.setCode(code);
            valve.setMachineIdentityCode(machineIdentityCode);
            valve.setName(name);
            valve.setMode(mode);
            valve.setDn(dn);
            valve.setDescription(description);
            valve.setState(state);
            valve.setOpening(opening);
            valveRepository.save(valve);
            return "Ok";
        }
    }

    @GetMapping(value = "/valve/message")
    public List<Valve> getAllValveMessage(){
        return valveRepository.findAll();
    }

}
