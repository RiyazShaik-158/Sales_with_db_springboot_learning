package com.learning.sales.dto.Sales;

public class SalesByItemResponseDto extends SalesByCustomerResponseDto {

    private String customerName;

    public SalesByItemResponseDto(String customerName, String itemName, int quantity, double price) {
        super(itemName, quantity, price);
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
