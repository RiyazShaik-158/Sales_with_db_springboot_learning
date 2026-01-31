package com.learning.sales.service;

import com.learning.sales.dto.Sales.SalesResponseDto;

import java.util.List;

public interface SaleService {

    List<SalesResponseDto> getAllSales();

    SalesResponseDto getSalesById(long id);

    List<SalesResponseDto> getSalesByCustomerId (long customerId);

    List<SalesResponseDto> getSalesByItemId (long itemId);
}
