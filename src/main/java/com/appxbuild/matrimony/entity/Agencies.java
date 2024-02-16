package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "agencies")
@JsonPropertyOrder({"id", "name", "short_description", "long_description", "created", "modified", "agency_status"})
public class Agencies {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_desc")
    @JsonProperty("short_description")
    private String shortDesk;

    @Column(name = "long_desc")
    @JsonProperty("long_description")
    private String longDesk;

    @Column(name = "created", nullable = false, updatable = false)
    private Timestamp created;

    @Column(name = "modified")
    private Timestamp modified;


    // foreign key -> connected to id column in AgencyStatuses
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency_status_id", referencedColumnName = "id")
    @JsonIgnoreProperties("agencies")
    @JsonProperty("agency_status")
    private AgencyStatuses agencyStatuses;

    // join Agencies to agency_id column in UserProfiles table
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "agencies", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnoreProperties("agencies")
    private List<UserProfiles> userProfiles;


    // constructor
    public Agencies() {}

    public Agencies(String name, String shortDesk, String longDesk, Timestamp created, Timestamp modified) {
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


    // ---------------------------
    public AgencyStatuses getAgencyStatuses() {
        return agencyStatuses;
    }

    public void setAgencyStatuses(AgencyStatuses agencyStatuses) {
        this.agencyStatuses = agencyStatuses;
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
        return "Agencies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDesk='" + shortDesk + '\'' +
                ", longDesk='" + longDesk + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", agencyStatuses=" + agencyStatuses +
                '}';
    }
}
