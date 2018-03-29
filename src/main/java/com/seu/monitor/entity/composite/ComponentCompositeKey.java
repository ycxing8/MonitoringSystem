package com.seu.monitor.entity.composite;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ComponentCompositeKey implements Serializable {
    private String machineIdentifier;//设备标志符和组件标志符一起为主键
    private String identifier;////允许多个组件拥有相同的标志符

    public ComponentCompositeKey(){
    }

    /*public ComponentCompositeKey(String machineIdentifier, String identifier){
        this.machineIdentifier = machineIdentifier;
        this.identifier = identifier;
    }*/

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
    //hashCode() 和 equals() 方法是抄来的，，
    //  ***重写hashCode与equals方法***  划重点！
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hash = 7;
        hash = PRIME * hash + ((machineIdentifier == null) ? 0 : machineIdentifier.hashCode());
        hash = PRIME * hash + ((identifier == null) ? 0 : identifier.hashCode());
        System.out.println("Use the hashCode");
        return hash;
    }


    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        final ComponentCompositeKey other = (ComponentCompositeKey)obj;
        if(machineIdentifier == null){
            if(other.machineIdentifier != null){
                return false;
            }
        }else if(!machineIdentifier.equals(other.machineIdentifier)){
            return false;
        }
        if(identifier == null){
            if(other.identifier != null){
                return false;
            }
        }else if(!identifier.equals(other.identifier)){
            return false;
        }
        return true;
    }


}
