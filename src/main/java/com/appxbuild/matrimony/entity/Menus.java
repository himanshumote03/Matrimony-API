package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menus {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "menu_order")
    private Integer menuOrder;

    @Column(name = "has_child")
    private Integer has_child;

    @Column(name = "lft")
    private Integer left;

    @Column(name = "rght")
    private Integer right;

    @Column(name = "url")
    private String url;

    @Column(name = "display")
    private Integer display;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "icon_class")
    private String iconClass;

    @Column(name = "controller")
    private String controller;

    @Column(name = "action")
    private String action;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "menus",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("menus")
    private List<MenusUsers> menusUsers;


    // define Constructor
    public Menus(){

    }
    public Menus(String name, Integer menuOrder, Integer has_child, Integer left, Integer right, String url, Integer display, Integer parentId, String iconClass, String controller, String action, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.menuOrder = menuOrder;
        this.has_child = has_child;
        this.left = left;
        this.right = right;
        this.url = url;
        this.display = display;
        this.parentId = parentId;
        this.iconClass = iconClass;
        this.controller = controller;
        this.action = action;
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

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Integer getHas_child() {
        return has_child;
    }

    public void setHas_child(Integer has_child) {
        this.has_child = has_child;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
        return "Menus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menuOrder=" + menuOrder +
                ", has_child=" + has_child +
                ", left=" + left +
                ", right=" + right +
                ", url='" + url + '\'' +
                ", display=" + display +
                ", parentId=" + parentId +
                ", iconClass='" + iconClass + '\'' +
                ", controller='" + controller + '\'' +
                ", action='" + action + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
