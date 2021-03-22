package com.example.softwareengineering.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity
@Table(name = "Transactions")
public class Transactions {
    private Integer TransactionID;
    private Integer RecordID;
    private BigDecimal Total;
    private String Type;
    private Integer TransactionEntryID;

    public Transactions() {
    }

    public Transactions(Integer transactionID, Integer recordID, BigDecimal total, String type, Integer transactionEntryID) {
        this.TransactionID = transactionID;
        this.RecordID = recordID;
        this.Total = total;
        this.Type = type;
        this.TransactionEntryID = transactionEntryID;
    }
    public Integer getTransactionID() { return TransactionID; }
    public void setTransactionID(Integer transactionID) { TransactionID = transactionID; }
    public Integer getRecordID() { return RecordID; }
    public void setRecordID(Integer recordID) { RecordID = recordID; }
    public BigDecimal getTotal() { return Total; }
    public void setTotal(BigDecimal total) { Total = total; }
    public String getType() { return Type; }
    public void setType(String type) { Type = type; }
    public Integer getTransactionEntryID() { return TransactionEntryID; }
    public void setTransactionEntryID(Integer transactionEntryID) { TransactionEntryID = transactionEntryID; }
}
