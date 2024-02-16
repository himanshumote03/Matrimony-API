package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agency_statuses")
public class AgencyStatuses {

    // fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;


    // join Agencies to agency_status_id column in Agencies table
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "agencyStatuses", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnoreProperties("agencyStatuses")
    private List<Agencies> agencies;


    // constructor
    public AgencyStatuses() {}

    public AgencyStatuses(String name, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
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

    public List<Agencies> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agencies> agencies) {
        this.agencies = agencies;
    }

    // add convenience method
    public void add(Agencies tempAgencies) {
        if (agencies == null){
            agencies = new ArrayList<>();
        }
        agencies.add(tempAgencies);
        tempAgencies.setAgencyStatuses(this);
    }

    // toString
    @Override
    public String toString() {
        return "AgencyStatuses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }

}
