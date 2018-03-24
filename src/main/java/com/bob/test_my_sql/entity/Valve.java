package com.bob.test_my_sql.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "valve")
public class Valve {//阀门

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String machineIdentityCode;
    private String name;
    private String mode;
    private String dn;
    private String description;
    private String state;
    private String opening;

    public Integer getId() {
        return id;
    }

    public String getMachineIdentityCode() {
        return machineIdentityCode;
    }

    public String getName() {
        return name;
    }

    public String getMode() {
        return mode;
    }

    public String getDn() {
        return dn;
    }

    public String getDescription() {
        return description;
    }

    public void setMachineIdentityCode(String machineIdentityCode) {
        this.machineIdentityCode = machineIdentityCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getOpening() {
        return opening;
    }

    public String getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public void setState(String state) {
        this.state = state;
    }
}
