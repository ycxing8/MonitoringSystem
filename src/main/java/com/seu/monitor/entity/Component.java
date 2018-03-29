package com.seu.monitor.entity;

import com.seu.monitor.entity.composite.ComponentCompositeKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@IdClass(ComponentCompositeKey.class)
@Table(name = "component")
public class Component implements Serializable {//部件，包括：传感器、阀门、电机、累计量

    @GeneratedValue
    private Integer id;
   // @Id private String machineIdentifier;//设备标志符和组件标志符一起为联合主键
   // @Id private String identifier;////允许多个组件拥有相同的标志符
    @EmbeddedId
    ComponentCompositeKey pk;
    private String kind;
    private String name;
    private String description;
    private String status;
    private String realTimeData;
    private String unit;//num:9

    public Component(){}

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public ComponentCompositeKey getPk() {
        return pk;
    }

    public void setPk(ComponentCompositeKey pk) {
        this.pk = pk;
    }

    public String getStatus() {
        return status;
    }

    public String getRealTimeData() {
        return realTimeData;
    }

    public void setRealTimeData(String realTimeData) {
        this.realTimeData = realTimeData;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }//num:18

}
