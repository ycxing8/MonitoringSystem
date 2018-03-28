package com.seu.monitor.entity.composite;

import java.io.Serializable;

public class ComponentLogCompositeKey implements Serializable {
    private String machineIdentifier;
    private String componentIdentifier;

    public void setMachineIdentifier(String machineIdentifier) {
        this.machineIdentifier = machineIdentifier;
    }

    public String getMachineIdentifier() {
        return machineIdentifier;
    }

    public void setComponentIdentifier(String componentIdentifier) {
        this.componentIdentifier = componentIdentifier;
    }

    public String getComponentIdentifier() {
        return componentIdentifier;
    }

}
