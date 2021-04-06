package com.example.softwareengineering.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TransactionEntries")
public class TransactionEntries {
    @Id
    private Integer TransactionEntryID;
    private Integer ProductID;
    private Integer Quantity;

    public TransactionEntries() {
    }

    public TransactionEntries(Integer transactionEntryID, Integer productID, Integer quantity) {
        this.TransactionEntryID = transactionEntryID;
        this.ProductID = productID;
        this.Quantity = quantity;
    }
    public Integer getTransactionEntryID() { return TransactionEntryID; }
    public void setTransactionEntryID(Integer transactionEntryID) { TransactionEntryID = transactionEntryID; }
    public Integer getProductID() { return ProductID; }
    public void setProductID(Integer productID) { ProductID = productID; }
    public Integer getQuantity() { return Quantity; }
    public void setQuantity(Integer quantity) { Quantity = quantity; }
}
