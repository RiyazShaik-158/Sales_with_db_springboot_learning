package com.learning.sales.controller;

import com.learning.sales.dto.Sales.SalesResponseDto;
import com.learning.sales.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Sales Controller")
@RequestMapping("/api/sales")
public class SalesController {

    private final SaleService saleService;

    public SalesController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    @Operation(summary = "Get All Sales")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesResponseDto> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Sales by Id")
    @ResponseStatus(HttpStatus.OK)
    public SalesResponseDto getSalesById(@PathVariable  long id) {
        return saleService.getSalesById(id);
    }

    @GetMapping("/customer/{id}")
    @Operation(summary = "Get Sales By Customer")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesResponseDto> getSalesByCustomerId(@PathVariable long id) {
        return saleService.getSalesByCustomerId(id);
    }

    @GetMapping("/item/{id}")
    @Operation(summary = "Get Sales by Item")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesResponseDto> getSalesByItemId(@PathVariable long id) {
        return saleService.getSalesByItemId(id);
    }
}
