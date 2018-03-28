package com.seu.monitor.socket.utils;

import com.seu.monitor.entity.Machine;
import com.seu.monitor.reposirity.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.List;

@Component
public class MachineUtils {

    @Autowired
    private MachineRepository machineRepository;

    public static MachineUtils machineUtils;

    @PostConstruct
    public void init() {
        machineUtils = this;
        machineUtils.machineRepository = this.machineRepository;
    }

    public static Machine findByMachineIdentityCode(String identityCode){
        //System.out.println(machineUtils.machineRepository);//for test
        //System.out.println(machineUtils.machineRepository.findByMachineIdentityCode(identityCode));
        List<Machine> machineList = machineUtils.machineRepository.findByIdentityCode(identityCode);
        if(machineList.size() == 0){
            return null;
        } else{
            return machineList.get(0);//取最上面的一个，且相同identity code 相同的machine应只有一个
        }
    }

}
