package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "devices")
public class Devices {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch =FetchType.EAGER )
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    @Column(name = "push_token")
    private String pushToken;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "device_model")
    private String deviceModel;

    @Column(name = "os_name")
    private String osName;

    @Column(name = "os_version")
    private String osVersion;

    @Column(name = "created", nullable = false, updatable = false)
    private Timestamp created;

    @Column(name = "modified")
    private Timestamp modified;

    // define constructor
    public Devices(){

    }
    public Devices(String pushToken, String deviceName, String deviceModel, String osName, String osVersion, Timestamp created, Timestamp modified) {
        this.pushToken = pushToken;
        this.deviceName = deviceName;
        this.deviceModel = deviceModel;
        this.osName = osName;
        this.osVersion = osVersion;
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

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    // define toString() method
    @Override
    public String toString() {
        return "Devices{" +
                "id=" + id +
                ", userId=" + users +
                ", pushToken='" + pushToken + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", osName='" + osName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }

}
