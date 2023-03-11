package com.arturrodev4.loyaltyapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String billNumber;
    private int amount;
    private boolean bindToClient;
    private LocalDateTime lastUpdateDate;
    private LocalDateTime createdDate;

    public String getBillNumber() {
        return billNumber;
    }
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }
    public int getId() {
        return id;
    }
    public int getAmount() {
        return amount;
    }
    public boolean isBindToClient() {
        return bindToClient;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setBindToClient(boolean bindToClient) {
        this.bindToClient = bindToClient;
    }

    public void updateFrom(Receipt receiptToSave){
        billNumber = receiptToSave.getBillNumber();
        amount = receiptToSave.getAmount();
        bindToClient = receiptToSave.isBindToClient();
    }

    @PrePersist
    void prePersist(){
        createdDate = LocalDateTime.now();
    }
    @PreUpdate
    void PreUpdate(){
        lastUpdateDate = LocalDateTime.now();
    }

}
