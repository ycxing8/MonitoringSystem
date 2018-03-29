package com.seu.monitor.entity;

import javax.persistence.*;

@Entity
@Table(name = "component_log")
public class ComponentLog {
	
	//部件记录信息，数据量大，部件包括：传感器、阀门、电机、累计量

    @Id
    @GeneratedValue
    private Integer id;
    private String machineIdentifier;
    private String componentIdentifier;
    private String time;
    private String status;
    private String data;
    private String unit;//num:6

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setMachineIdentifier(String machineIdentifier) {
        this.machineIdentifier = machineIdentifier;
    }

    public String getUnit() {
        return unit;
    }

    public String getMachineIdentifier() {
        return machineIdentifier;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComponentIdentifier() {
        return componentIdentifier;
    }

    public void setComponentIdentifier(String componentIdentifier) {
        this.componentIdentifier = componentIdentifier;
    }

    public Integer getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTime(String time) {
        this.time = time;
    }//num:12

}