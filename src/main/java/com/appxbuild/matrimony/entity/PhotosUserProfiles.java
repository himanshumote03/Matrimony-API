package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "photos_user_profiles")
public class PhotosUserProfiles {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photos photos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id")
    private UserProfiles userProfiles ;

    @Column(name = "created",nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    //define constructor
    public PhotosUserProfiles(){

    }
    public PhotosUserProfiles(Photos photos, LocalDateTime created, LocalDateTime modified) {
        this.photos = photos;
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

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
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

    // define toString
    @Override
    public String toString() {
        return "PhotosUserProfiles{" +
                "id=" + id +
                ", photos=" + photos +
                ", userProfiles=" + userProfiles +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
