package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch =FetchType.EAGER )
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;


    @Column(name = "agent_id")
    private Integer agent;

    @ManyToOne(fetch =FetchType.EAGER )
    @JoinColumn(name = "package_id", referencedColumnName = "id")
    private Packages packages;

    @Column(name = "actual_cost")
    private Double actualCost;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "discounted_cost")
    private Double discountedCost;

    @Column(name = "gst")
    private Double gst;

    @Column(name = "final_cost")
    private Double finalCost;

    @Column(name = "agentCommission")
    private Double agentCommission;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne(fetch =FetchType.EAGER )
    @JoinColumn(name = "subscription_status_id", referencedColumnName = "id")
    private SubscriptionStatuses subscriptionStatuses;

    @Column(name = "created", updatable = false, nullable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @ManyToOne(fetch =FetchType.EAGER )
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private Transactions transactions;

    // define constructor
    public Subscriptions() {}

    public Subscriptions(String name, Double actualCost, Double discount, Double discountedCost, Double gst, Double finalCost, Double agentCommission, LocalDateTime startDate, LocalDateTime endDate, SubscriptionStatuses subscriptionStatuses, LocalDateTime created, LocalDateTime modified, Transactions transactions) {
        this.name = name;
        this.actualCost = actualCost;
        this.discount = discount;
        this.discountedCost = discountedCost;
        this.gst = gst;
        this.finalCost = finalCost;
        this.agentCommission = agentCommission;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subscriptionStatuses = subscriptionStatuses;
        this.created = created;
        this.modified = modified;
        this.transactions = transactions;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
    }

    public Double getActualCost() {
        return actualCost;
    }

    public void setActualCost(Double actualCost) {
        this.actualCost = actualCost;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscountedCost() {
        return discountedCost;
    }

    public void setDiscountedCost(Double discountedCost) {
        this.discountedCost = discountedCost;
    }

    public Double getGst() {
        return gst;
    }

    public void setGst(Double gst) {
        this.gst = gst;
    }

    public Double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Double finalCost) {
        this.finalCost = finalCost;
    }

    public Double getAgentCommission() {
        return agentCommission;
    }

    public void setAgentCommission(Double agentCommission) {
        this.agentCommission = agentCommission;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public SubscriptionStatuses getSubscriptionStatuses() {
        return subscriptionStatuses;
    }

    public void setSubscriptionStatuses(SubscriptionStatuses subscriptionStatuses) {
        this.subscriptionStatuses = subscriptionStatuses;
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

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    // define toString() method
    @Override
    public String toString() {
        return "Subscriptions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", agent=" + agent +
                ", packages=" + packages +
                ", actualCost=" + actualCost +
                ", discount=" + discount +
                ", discountedCost=" + discountedCost +
                ", gst=" + gst +
                ", finalCost=" + finalCost +
                ", agentCommission=" + agentCommission +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", subscriptionStatuses=" + subscriptionStatuses +
                ", created=" + created +
                ", modified=" + modified +
                ", transactions=" + transactions +
                '}';
    }
}
