package com.learning.sales.dto.Customer;

import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.RequestBody;

public class CustomerRequestDto {

    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    private String name;

    @Size(min = 1, max = 100, message = "Address must be between 1 and 100 characters")
    private String address;

    @Size(min = 1, max = 50, message = "City must be between 1 and 50 characters")
    private String city;

    @Size(min = 2, max = 2, message = "State must be of 2 characters")
    private String state;

    @Size(min = 5, max = 5, message = "Zip must be of 5 characters")
    private String zip;

    public CustomerRequestDto(String name, String address, String city, String state, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
