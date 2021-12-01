package com.bsu.tpbackend.entity;
import com.bsu.tpbackend.enumeration.FeederStatusEnum;
import com.bsu.tpbackend.enumeration.FeederTypeEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeederEntity implements CustomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private FeederTypeEnum type;
    private Double capacity;
    private Double currentVolume;
    private Boolean active;
    private FeederStatusEnum status;
    private Integer activeScheduleId;

    public FeederEntity() {
        this.active=false;
        this.status=FeederStatusEnum.WAITING;
    }

    public FeederEntity(Integer id, String name, FeederTypeEnum type, Double capacity,
                        Double currentVolume, Boolean active, FeederStatusEnum status, Integer activeScheduleId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.currentVolume = currentVolume;
        this.active = active;
        this.status = status;
        this.activeScheduleId = activeScheduleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeederTypeEnum getType() {
        return type;
    }

    public void setType(FeederTypeEnum type) {
        this.type = type;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(Double currentVolume) {
        this.currentVolume = currentVolume;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public FeederStatusEnum getStatus() {
        return status;
    }

    public void setStatus(FeederStatusEnum status) {
        this.status = status;
    }

    public Integer getActiveScheduleId() {
        return activeScheduleId;
    }

    public void setActiveScheduleId(Integer activeScheduleId) {
        this.activeScheduleId = activeScheduleId;
    }
}
