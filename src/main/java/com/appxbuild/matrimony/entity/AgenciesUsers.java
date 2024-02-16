package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "agencies_users")
public class AgenciesUsers {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency_id", referencedColumnName = "id")
    @JsonIgnoreProperties("agencies_users")
    private Agencies agencies;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("agencies_users")
    private Users users;

    @Column(name = "created", nullable = false, updatable = false)
    private Timestamp created;

    @Column(name = "modified")
    private Timestamp modified;

    // constructor
    public AgenciesUsers(){

    }

    public AgenciesUsers(Timestamp created, Timestamp modified) {
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

    public Agencies getAgencies() {
        return agencies;
    }

    public void setAgencies(Agencies agencies) {
        this.agencies = agencies;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

    // toString()
    @Override
    public String toString() {
        return "AgenciesUsers{" +
                "id=" + id +
                ", agencies=" + agencies +
                ", users=" + users +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
