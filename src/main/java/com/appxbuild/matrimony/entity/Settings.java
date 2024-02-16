package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "settings")
public class Settings {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("settings")
    private Users users;

    @Column(name = "notification_enabled")
    private byte notificationEnabled;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    // define constructor
    public Settings(){

    }
    public Settings(Users users, byte notificationEnabled, LocalDateTime created, LocalDateTime modified) {
        this.users = users;
        this.notificationEnabled = notificationEnabled;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public byte getNotificationEnabled() {
        return notificationEnabled;
    }

    public void setNotificationEnabled(byte notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
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
        return "Settings{" +
                "id=" + id +
                ", users=" + users +
                ", notificationEnabled=" + notificationEnabled +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
