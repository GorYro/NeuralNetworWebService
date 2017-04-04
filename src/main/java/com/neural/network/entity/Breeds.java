package com.neural.network.entity;

import javax.persistence.*;

@Entity
@Table(name = "breeds")
public class Breeds {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "breeds")
    private String breeds;

    @Column(name = "links")
    private String links;

    public Breeds() {
    }

    public Breeds(String breeds, String links) {
        this.breeds = breeds;
        this.links = links;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBreeds() {
        return breeds;
    }

    public void setBreeds(String breeds) {
        this.breeds = breeds;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }
}
