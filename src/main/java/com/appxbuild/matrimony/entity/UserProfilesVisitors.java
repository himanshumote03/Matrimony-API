package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_profiles_visitors")
public class UserProfilesVisitors {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id")
    private UserProfiles userProfiles;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "visitor_id", referencedColumnName = "id")
    private Visitors visitors;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    //define constructor
    public UserProfilesVisitors(){

    }

    public UserProfilesVisitors(LocalDateTime created, LocalDateTime modified) {
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

    public UserProfiles getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(UserProfiles userProfiles) {
        this.userProfiles = userProfiles;
    }

    public Visitors getVisitors() {
        return visitors;
    }

    public void setVisitors(Visitors visitors) {
        this.visitors = visitors;
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

    // define toString
    @Override
    public String toString() {
        return "UserProfilesVisitors{" +
                "id=" + id +
                ", userProfiles=" + userProfiles +
                ", visitors=" + visitors +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }

}
