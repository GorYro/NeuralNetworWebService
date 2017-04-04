package com.neural.network.entity;

import javax.persistence.*;


@Entity
@Table(name = "uuid")
public class Uuid {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "uuid")
    private String uuid;

    public Uuid() {
    }

    public Uuid(String uuid) {
        this.uuid = uuid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
