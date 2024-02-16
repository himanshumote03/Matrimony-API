package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "active")
    private Byte active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_status_id", referencedColumnName = "id")
    @JsonIgnoreProperties("users")
    private UserStatuses userStatuses;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="type_id", referencedColumnName = "id")
    @JsonIgnoreProperties("users")
    private Types typeId;

    @Column(name = "otp")
    private String otp;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "facebook_identification")
    private String facebookIdentification;

    @Column(name = "facebook_token")
    private String facebookToken;

    @Column(name = "google_identification")
    private String googleIdentification;


    @Column(name = "google_token")
    private String googleToken;

    @Column(name = "apple_identification")
    private String appleIdentification;

    @Column(name = "apple_token")
    private String appleToken;

    @Column(name ="latitude")
    private Double latitude;

    @Column(name ="longitude")
    private Double longitude;

    @Column(name ="password_token")
    private String passwordToken;

    @Column(name ="password_token_expire")
    private LocalDateTime passwordTokenExpire;

    @Column(name ="confirm_email_token")
    private String confirmEmailToken;

    @Column(name ="email_verified")
    private byte emailVerified;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_relative_id", referencedColumnName = "id")
    @JsonIgnoreProperties("users")
    private UserRelatives userRelativeId;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name ="short_code")
    private String shortCode;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;


    // join Users to user_id column in UserProfiles table
    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<UserProfiles> userProfiles;

    // constructor
    public Users () {}

    public Users(String userName, String password, String email, String firstName, String middleName, String lastName, Byte active, String otp, String mobile, String facebookIdentification, String facebookToken, String googleIdentification, String googleToken, String appleIdentification, String appleToken, Double latitude, Double longitude, String passwordToken, LocalDateTime passwordTokenExpire, String confirmEmailToken, byte emailVerified, Integer parentId, String shortCode, LocalDateTime created, LocalDateTime modified) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.active = active;
        this.otp = otp;
        this.mobile = mobile;
        this.facebookIdentification = facebookIdentification;
        this.facebookToken = facebookToken;
        this.googleIdentification = googleIdentification;
        this.googleToken = googleToken;
        this.appleIdentification = appleIdentification;
        this.appleToken = appleToken;
        this.latitude = latitude;
        this.longitude = longitude;
        this.passwordToken = passwordToken;
        this.passwordTokenExpire = passwordTokenExpire;
        this.confirmEmailToken = confirmEmailToken;
        this.emailVerified = emailVerified;
        this.parentId = parentId;
        this.shortCode = shortCode;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFacebookIdentification() {
        return facebookIdentification;
    }

    public void setFacebookIdentification(String facebookIdentification) {
        this.facebookIdentification = facebookIdentification;
    }

    public String getFacebookToken() {
        return facebookToken;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public String getGoogleIdentification() {
        return googleIdentification;
    }

    public void setGoogleIdentification(String googleIdentification) {
        this.googleIdentification = googleIdentification;
    }

    public String getGoogleToken() {
        return googleToken;
    }

    public void setGoogleToken(String googleToken) {
        this.googleToken = googleToken;
    }

    public String getAppleIdentification() {
        return appleIdentification;
    }

    public void setAppleIdentification(String appleIdentification) {
        this.appleIdentification = appleIdentification;
    }

    public String getAppleToken() {
        return appleToken;
    }

    public void setAppleToken(String appleToken) {
        this.appleToken = appleToken;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPasswordToken() {
        return passwordToken;
    }

    public void setPasswordToken(String passwordToken) {
        this.passwordToken = passwordToken;
    }

    public LocalDateTime getPasswordTokenExpire() {
        return passwordTokenExpire;
    }

    public void setPasswordTokenExpire(LocalDateTime passwordTokenExpire) {
        this.passwordTokenExpire = passwordTokenExpire;
    }

    public String getConfirmEmailToken() {
        return confirmEmailToken;
    }

    public void setConfirmEmailToken(String confirmEmailToken) {
        this.confirmEmailToken = confirmEmailToken;
    }

    public byte getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(byte emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
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

    // -------------------------------------

    public UserStatuses getUserStatuses() {
        return userStatuses;
    }

    public void setUserStatuses(UserStatuses userStatuses) {
        this.userStatuses = userStatuses;
    }

    public Types getTypeId() {
        return typeId;
    }

    public void setTypeId(Types typeId) {
        this.typeId = typeId;
    }

    public UserRelatives getUserRelativeId() {
        return userRelativeId;
    }

    public void setUserRelativeId(UserRelatives userRelativeId) {
        this.userRelativeId = userRelativeId;
    }

    // toString()
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", typeId=" + typeId +
                ", otp='" + otp + '\'' +
                ", mobile='" + mobile + '\'' +
                ", facebookIdentification='" + facebookIdentification + '\'' +
                ", facebookToken='" + facebookToken + '\'' +
                ", googleIdentification='" + googleIdentification + '\'' +
                ", googleToken='" + googleToken + '\'' +
                ", appleIdentification='" + appleIdentification + '\'' +
                ", appleToken='" + appleToken + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", passwordToken='" + passwordToken + '\'' +
                ", passwordTokenExpire=" + passwordTokenExpire +
                ", confirmEmailToken='" + confirmEmailToken + '\'' +
                ", emailVerified=" + emailVerified +
                ", userRelativeId=" + userRelativeId +
                ", parentId=" + parentId +
                ", shortCode='" + shortCode + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
