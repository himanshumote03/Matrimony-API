package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "occupations")
public class Occupations {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "icon_name")
    private String iconName;

    @Column(name = "selected_thumbnail_id")
    private String selectedThumbnailId;

    @Column(name = "unselected_thumbnail_id")
    private String unselectedThumbnailId;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "occupations", fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnoreProperties("occupations")
    private List<UserProfiles> userProfiles;

    // constructor
    public Occupations() {}

    public Occupations(String name, String color, String iconName, String selectedThumbnailId, String unselectedThumbnailId, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.color = color;
        this.iconName = iconName;
        this.selectedThumbnailId = selectedThumbnailId;
        this.unselectedThumbnailId = unselectedThumbnailId;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getSelectedThumbnailId() {
        return selectedThumbnailId;
    }

    public void setSelectedThumbnailId(String selectedThumbnailId) {
        this.selectedThumbnailId = selectedThumbnailId;
    }

    public String getUnselectedThumbnailId() {
        return unselectedThumbnailId;
    }

    public void setUnselectedThumbnailId(String unselectedThumbnailId) {
        this.unselectedThumbnailId = unselectedThumbnailId;
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

    // ----------------------------------------

//    public List<UserProfiles> getUserProfiles() {
//        return userProfiles;
//    }
//
//    public void setUserProfiles(List<UserProfiles> userProfiles) {
//        this.userProfiles = userProfiles;
//    }


    // toString()

    @Override
    public String toString() {
        return "Occupations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", iconName='" + iconName + '\'' +
                ", selectedThumbnailId='" + selectedThumbnailId + '\'' +
                ", unselectedThumbnailId='" + unselectedThumbnailId + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
