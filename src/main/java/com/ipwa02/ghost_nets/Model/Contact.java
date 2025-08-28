package com.ipwa02.ghost_nets.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contact {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
