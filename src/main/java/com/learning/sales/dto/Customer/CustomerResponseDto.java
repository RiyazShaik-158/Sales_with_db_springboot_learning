package com.learning.sales.dto.Customer;

import jakarta.validation.constraints.NotNull;

public class CustomerResponseDto extends CustomerRequestDto {

    @NotNull
    private long id;

    public CustomerResponseDto(long id, String name, String address, String city, String state, String zip) {
        super(name, address, city, state, zip);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
