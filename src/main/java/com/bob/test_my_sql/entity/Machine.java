package com.bob.test_my_sql.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machine")
public class Machine {
    @Id
    @GeneratedValue
    private Integer id;

    private String machineState;

    private String machineName;

    private String machinePlace;

    private String machineDescription;

    private String machineIdentityCode;

    private String machinePicturePath;

    public Machine(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMachineState() {
        return machineState;
    }

    public void setMachineState(String machineState) {
        this.machineState = machineState;
    }

    public String getMachineIdentityCode() {
        return machineIdentityCode;
    }

    public void setMachineIdentityCode(String machineIdentityCode) {
        this.machineIdentityCode = machineIdentityCode;
    }

    public void setMachineDescription(String machineDescription) {
        this.machineDescription = machineDescription;
    }

    public void setMachinePlace(String machinePlace) {
        this.machinePlace = machinePlace;
    }

    public String getMachineDescription() {
        return machineDescription;
    }

    public String getMachinePlace() {
        return machinePlace;
    }

    public String getMachinePicturePath() {
        return machinePicturePath;
    }

    public void setMachinePicturePath(String machinePicturePath) {
        this.machinePicturePath = machinePicturePath;
    }
}
