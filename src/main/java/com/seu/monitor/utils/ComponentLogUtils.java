package com.seu.monitor.utils;

import com.seu.monitor.entity.ComponentLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.seu.monitor.repository.ComponentLogRepository;

import javax.annotation.PostConstruct;

@Component
public class ComponentLogUtils {

    @Autowired
    private ComponentLogRepository componentLogRepository;

    public static ComponentLogUtils componentLogUtils;
    @PostConstruct
    public void init() {
        componentLogUtils = this;
        componentLogUtils.componentLogRepository = this.componentLogRepository;
    }

    public static void addComponentLog(ComponentLog componentLog){
        componentLogUtils.componentLogRepository.save(componentLog);

    }



}
