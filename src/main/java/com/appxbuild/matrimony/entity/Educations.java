package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "educations")
public class Educations {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_desc")
    private String shortDesk;

    @Column(name = "long_desc")
    private String longDesk;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;


    // join education to education_id column in UserProfiles table
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "educations", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnoreProperties("educations")
    private List<UserProfiles> userProfiles;


    // constructor
    public Educations() {}

    public Educations(String name, String shortDesk, String longDesk, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.shortDesk = shortDesk;
        this.longDesk = longDesk;
        this.created = created;
        this.modified = modified;
    }


    // getter/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesk() {
        return shortDesk;
    }

    public void setShortDesk(String shortDesk) {
        this.shortDesk = shortDesk;
    }

    public String getLongDesk() {
        return longDesk;
    }

    public void setLongDesk(String longDesk) {
        this.longDesk = longDesk;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }


    // ---------------------------
//    public List<UserProfiles> getUserProfiles() {
//        return userProfiles;
//    }
//
//    public void setUserProfiles(List<UserProfiles> userProfiles) {
//        this.userProfiles = userProfiles;
//    }

    // toString method()
    @Override
    public String toString() {
        return "Educations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDesk='" + shortDesk + '\'' +
                ", longDesk='" + longDesk + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
