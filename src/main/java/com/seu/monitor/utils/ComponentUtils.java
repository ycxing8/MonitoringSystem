package com.seu.monitor.utils;

import com.seu.monitor.entity.ComponentLog;
import com.seu.monitor.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.List;

@Component
public class ComponentUtils {

    @Autowired
    private ComponentRepository componentRepository;
    public static ComponentUtils componentUtils;

    @PostConstruct
    public void init() {
        componentUtils = this;
        componentUtils.componentRepository = this.componentRepository;
    }

    public static boolean modifyComponentRealTimeData(ComponentLog componentLog) {

        //System.out.println("You run here!");//for test
        //System.out.println(componentLog.getComponentIdentifier());
        //System.out.println(componentLog.getData());
        //System.out.println(componentUtils.componentRepository);

        List<com.seu.monitor.entity.Component> componentList =
                componentUtils.componentRepository.findByPkMachineIdentifierAndPkIdentifier(
                        componentLog.getMachineIdentifier(),componentLog.getComponentIdentifier());

        //System.out.println("You have accessed database!");//for test
        //System.out.println(componentLog.getComponentIdentifier() +" this machine num is: " +componentList.size());

        if(componentList != null && componentList.size() == 1){
            com.seu.monitor.entity.Component component = componentList.get(0);
            component.setRealTimeData(componentLog.getData());
            component.setStatus(componentLog.getStatus());
            component.setUnit(componentLog.getUnit());
            componentUtils.componentRepository.save(component);
            return true;
        }
        return false;
    }
}
