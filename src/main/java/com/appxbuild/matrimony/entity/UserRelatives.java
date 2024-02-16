package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user_relatives")
public class UserRelatives {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "relation")
    private String relation;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "long_desc")
    private String longDesc;

    @Column(name = "created",nullable = false, updatable = false)
    private Timestamp created;

    @Column(name = "modified")
    private Timestamp modified;

    // add @OneToMany annotation
    @OneToMany(mappedBy = "userRelativeId",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("userRelatives")
    private List<Users> users;

    //define constructor
    public UserRelatives(){

    }
    public UserRelatives(String name, String relation, String shortDesc, String longDesc, Timestamp created, Timestamp modified) {
        this.name = name;
        this.relation = relation;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
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


    // define toString
    @Override
    public String toString() {
        return "UserRelatives{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", relation='" + relation + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }


}
