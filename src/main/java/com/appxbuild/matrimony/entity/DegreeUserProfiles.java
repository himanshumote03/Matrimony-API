package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "degrees_user_profiles")
public class DegreeUserProfiles {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "degree_id",referencedColumnName = "id")
    private Degrees degrees;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_profile_id",referencedColumnName = "id")
    private UserProfiles userProfiles;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    // define constructor
    public DegreeUserProfiles(){

    }
    public DegreeUserProfiles(LocalDateTime created, LocalDateTime modified) {
        this.created = created;
        this.modified = modified;
    }

    // define getter/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Degrees getDegrees() {
        return degrees;
    }

    public void setDegrees(Degrees degrees) {
        this.degrees = degrees;
    }

    public UserProfiles getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(UserProfiles userProfiles) {
        this.userProfiles = userProfiles;
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

    // define toString() method
    @Override
    public String toString() {
        return "DegreeUserProfile{" +
                "id=" + id +
                ", degrees=" + degrees +
                ", userProfiles=" + userProfiles +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
