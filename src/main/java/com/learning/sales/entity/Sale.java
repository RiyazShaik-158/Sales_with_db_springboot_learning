package com.learning.sales.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "item_id")
    private long item_id;

    @Column(name = "customer_id")
    private long customer_id;

    @Column(name = "date")
    private Date date;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    public Sale(long id, long item_id, long customer_id, Date date, int quantity, double price) {
        this.id = id;
        this.item_id = item_id;
        this.customer_id = customer_id;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
    }

    public Sale() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
