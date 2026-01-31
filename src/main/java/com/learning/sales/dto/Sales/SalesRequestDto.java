package com.learning.sales.dto.Sales;

import java.util.Date;

public class SalesRequestDto {

    private long itemId;
    private long customerId;
    private Date date;
    private int quantity;
    private double price;

    public SalesRequestDto(long itemId, long customerId, Date date, int quantity, double price) {
        this.itemId = itemId;
        this.customerId = customerId;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
    }

    public SalesRequestDto() {
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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
