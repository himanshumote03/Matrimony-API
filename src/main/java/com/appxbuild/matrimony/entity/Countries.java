package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "countries")
public class Countries {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sortname")
    private String sortName;

    @Column(name = "name")
    private String name;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;


    // join States to state_id in countries table
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "countries", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnoreProperties("countries")
    private List<States> states;

    // join UserProfiles to currentCountryId in UserProfile table
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currentCountryId", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnoreProperties("countries")
    private List<UserProfiles> userProfiles;

// join UserProfiles
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "permanentCountryId", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnoreProperties("countries")
    private List<UserProfiles> userProfiles1;


    // constructor
    public Countries() {}

    public Countries(String sortName, String name, String currencyCode, String currencyName, String symbol, LocalDateTime created, LocalDateTime modified) {
        this.sortName = sortName;
        this.name = name;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.symbol = symbol;
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

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
//    public List<States> getStates() {
//        return states;
//    }
//
//    public void setStates(List<States> states) {
//        this.states = states;
//    }

    // toString()
    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", sortName='" + sortName + '\'' +
                ", name='" + name + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", symbol='" + symbol + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
