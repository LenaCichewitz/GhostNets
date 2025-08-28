package com.ipwa02.ghost_nets.Model;

import com.ipwa02.ghost_nets.Statuses;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Net {
    Statuses status;
    float estimatedSize;
    String gpsLocation;
    int contactId;
    int bergerId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Statuses getStatus() {
        return status;
    }

    public float getEstimatedSize() {
        return estimatedSize;
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setBergerId(int bergerId) {
        this.bergerId = bergerId;
    }

    public int getBergerId() {
        return bergerId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setEstimatedSize(float estimatedSize) {
        this.estimatedSize = estimatedSize;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
