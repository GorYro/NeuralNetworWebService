package com.neural.network.entity;


import javax.persistence.*;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "breeds")
    private String breeds;

    @Column(name = "score")
    private String score;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "link")
    private String link;

    public Data() {
    }

    public Data(String breeds, String score, String uuid, String link) {
        this.breeds = breeds;
        this.score = score;
        this.uuid = uuid;
        this.link = link;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", breeds='" + breeds + '\'' +
                ", score='" + score + '\'' +
                ", uuid='" + uuid + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
