package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transactions")
public class Transactions {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("transactions")
    private Users users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_gateway_id", referencedColumnName = "id")
    @JsonIgnoreProperties("transactions")
    private PaymentGateways paymentGateways;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_status_id", referencedColumnName = "id")
    @JsonIgnoreProperties("transactions")
    private TransactionsStatuses transactionsStatuses;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_gateway_transaction_ref")
    private Integer paymentGatewayTransactionRef;

    @Column(name = "notes")
    private String notes;

    @Column(name = "transaction_response")
    private String transactionResponse;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "transactions", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("transactions")
    private List<Subscriptions> subscriptions;

    // define constructor
    public Transactions() {}

    public Transactions(Double amount, Integer paymentGatewayTransactionRef, String notes, String transactionResponse, LocalDateTime created, LocalDateTime modified) {
        this.amount = amount;
        this.paymentGatewayTransactionRef = paymentGatewayTransactionRef;
        this.notes = notes;
        this.transactionResponse = transactionResponse;
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

    public PaymentGateways getPaymentGateways() {
        return paymentGateways;
    }

    public void setPaymentGateways(PaymentGateways paymentGateways) {
        this.paymentGateways = paymentGateways;
    }

    public TransactionsStatuses getTransactionsStatuses() {
        return transactionsStatuses;
    }

    public void setTransactionsStatuses(TransactionsStatuses transactionsStatuses) {
        this.transactionsStatuses = transactionsStatuses;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getPaymentGatewayTransactionRef() {
        return paymentGatewayTransactionRef;
    }

    public void setPaymentGatewayTransactionRef(Integer paymentGatewayTransactionRef) {
        this.paymentGatewayTransactionRef = paymentGatewayTransactionRef;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTransactionResponse() {
        return transactionResponse;
    }

    public void setTransactionResponse(String transactionResponse) {
        this.transactionResponse = transactionResponse;
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
        return "Transactions{" +
                "id=" + id +
                ", users=" + users +
                ", paymentGateways=" + paymentGateways +
                ", transactionsStatuses=" + transactionsStatuses +
                ", amount=" + amount +
                ", paymentGatewayTransactionRef=" + paymentGatewayTransactionRef +
                ", notes='" + notes + '\'' +
                ", transactionResponse='" + transactionResponse + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
