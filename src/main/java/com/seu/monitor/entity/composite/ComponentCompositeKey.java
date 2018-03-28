package com.seu.monitor.entity.composite;

import java.io.Serializable;

public class ComponentCompositeKey implements Serializable {
    private String machineIdentifier;//设备标志符和组件标志符一起为主键
    private String identifier;////允许多个组件拥有相同的标志符

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getMachineIdentifier() {
        return machineIdentifier;
    }

    public void setMachineIdentifier(String machineIdentifier) {
        this.machineIdentifier = machineIdentifier;
    }
}
