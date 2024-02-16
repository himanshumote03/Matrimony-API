package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "app_updates")
public class AppUpdates {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "platform")
    private String platform;

    @Column(name = "version")
    private String version;

    @Column(name = "version_code")
    private Integer versionCode;

    @Column(name = "critical")
    private byte critical;

    @Column(name = "message")
    private String message;

    @Column(name = "url")
    private String url;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    // define constructor
    public AppUpdates(){ }
    public AppUpdates(String platform, String version, Integer versionCode, byte critical, String message, String url, LocalDateTime created, LocalDateTime modified) {
        this.platform = platform;
        this.version = version;
        this.versionCode = versionCode;
        this.critical = critical;
        this.message = message;
        this.url = url;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public byte getCritical() {
        return critical;
    }

    public void setCritical(byte critical) {
        this.critical = critical;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return "AppUpdates{" +
                "id=" + id +
                ", platform='" + platform + '\'' +
                ", version='" + version + '\'' +
                ", versionCode=" + versionCode +
                ", critical=" + critical +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
