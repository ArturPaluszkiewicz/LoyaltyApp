package com.arturrodev4.loyaltyapp.model;

import jakarta.persistence.*;
@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String billNumber;
    private int amount;
    private boolean bindToClient;

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
}
