package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table( name = "favourites_user_profiles")
public class FavouriteUserProfile {


    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id")
    private UserProfiles userProfiles;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "favourite_id", referencedColumnName = "id")
    private Favourites favourites;

    @Column(name = "created", updatable = false, nullable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    // define constructor
    public FavouriteUserProfile(){

    }
    public FavouriteUserProfile(LocalDateTime created, LocalDateTime modified) {
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

    public Favourites getFavourites() {
        return favourites;
    }

    public void setFavourites(Favourites favourites) {
        this.favourites = favourites;
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
        return "FavouriteUserProfile{" +
                "id=" + id +
                ", userProfiles=" + userProfiles +
                ", favourites=" + favourites +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
