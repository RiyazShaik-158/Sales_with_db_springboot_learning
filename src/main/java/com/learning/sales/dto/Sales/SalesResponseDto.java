package com.learning.sales.dto.Sales;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class SalesResponseDto extends SalesRequestDto {

    @NotNull
    private long id;

    public SalesResponseDto(long id, long itemId, long customerId, Date date, int quantity, double price) {
        super(itemId, customerId, date, quantity, price);
        this.id = id;
    }

    public SalesResponseDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
