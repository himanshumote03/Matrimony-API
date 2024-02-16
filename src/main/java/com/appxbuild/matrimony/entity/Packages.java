package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "packages")
public class Packages {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "long_desc")
    private String longDesc;

    @Column(name = "base_price")
    private Double basePrice;

    @Column(name = "offer_price")
    private Double offerPrice;

    @Column(name = "discount_percent")
    private Double discountPercent;

    @Column(name = "duration")
    private Integer duration;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "package_status_id", referencedColumnName = "id")
    @JsonIgnoreProperties("packages")
    private PackageStatuses packageStatuses;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "packages", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("packages")
    private List<Subscriptions> subscriptions;

    // define constructor
    public Packages() {}

    public Packages(String name, String shortDesc, String longDesc, Double basePrice, Double offerPrice, Double discountPercent, Integer duration, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.basePrice = basePrice;
        this.offerPrice = offerPrice;
        this.discountPercent = discountPercent;
        this.duration = duration;
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

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public PackageStatuses getPackageStatuses() {
        return packageStatuses;
    }

    public void setPackageStatuses(PackageStatuses packageStatuses) {
        this.packageStatuses = packageStatuses;
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
        return "Packages{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", basePrice=" + basePrice +
                ", offerPrice=" + offerPrice +
                ", discountPercent=" + discountPercent +
                ", duration=" + duration +
                ", packageStatuses=" + packageStatuses +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
