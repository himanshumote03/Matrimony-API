package com.appxbuild.matrimony.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_references")
public class UserReferences {

     // define fields
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private int id;

     @ManyToOne(fetch =FetchType.EAGER )
     @JoinColumn(name = "user_id", referencedColumnName = "id")
//     @JsonIgnoreProperties("user_references")
     private Users users;

     @Column(name = "name")
     private String name;

     @Column(name = "email")
     private String email;

     @Column(name = "mobile")
     private String mobile;

     @Column(name = "address")
     private String address;

     @Column(name = "city_id")
     private Integer cityID;

     @Column(name = "city_name")
     private String cityName;

     @Column(name = "state_id")
     private int stateId;

     @Column(name = "state_name")
     private String stateName;

     @Column(name = "created", updatable = false, nullable = false)
     private LocalDateTime created;

     @Column(name = "modified")
     private LocalDateTime modified;

     // define constructor
     public UserReferences(){

     }
     public UserReferences(String name, String email, String mobile, String address, Integer cityID, String cityName, int stateId, String stateName, LocalDateTime created, LocalDateTime modified) {
          this.name = name;
          this.email = email;
          this.mobile = mobile;
          this.address = address;
          this.cityID = cityID;
          this.cityName = cityName;
          this.stateId = stateId;
          this.stateName = stateName;
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

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getMobile() {
          return mobile;
     }

     public void setMobile(String mobile) {
          this.mobile = mobile;
     }

     public String getAddress() {
          return address;
     }

     public void setAddress(String address) {
          this.address = address;
     }

     public Integer getCityID() {
          return cityID;
     }

     public void setCityID(Integer cityID) {
          this.cityID = cityID;
     }

     public String getCityName() {
          return cityName;
     }

     public void setCityName(String cityName) {
          this.cityName = cityName;
     }

     public int getStateId() {
          return stateId;
     }

     public void setStateId(int stateId) {
          this.stateId = stateId;
     }

     public String getStateName() {
          return stateName;
     }

     public void setStateName(String stateName) {
          this.stateName = stateName;
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
          return "UserReferences{" +
                  "id=" + id +
                  ", users=" + users +
                  ", name='" + name + '\'' +
                  ", email='" + email + '\'' +
                  ", mobile='" + mobile + '\'' +
                  ", address='" + address + '\'' +
                  ", cityID=" + cityID +
                  ", cityName='" + cityName + '\'' +
                  ", stateId=" + stateId +
                  ", stateName='" + stateName + '\'' +
                  ", created=" + created +
                  ", modified=" + modified +
                  '}';
     }
}
