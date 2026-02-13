package com.learning.sales.service;

import com.learning.sales.dto.Sales.SalesByCustomerResponseDto;
import com.learning.sales.dto.Sales.SalesByItemResponseDto;
import com.learning.sales.dto.Sales.SalesRequestDto;
import com.learning.sales.dto.Sales.SalesResponseDto;

import java.util.List;

public interface SaleService {

    List<SalesResponseDto> getAllSales();

    SalesResponseDto getSalesById(long id);

    List<SalesByItemResponseDto> getSalesByCustomerId (long customerId);

    List<SalesByItemResponseDto> getSalesByItemId (long itemId);

    void addSales(SalesRequestDto salesRequestDto);

    void editSales(long id, SalesRequestDto salesRequestDto);

    void deleteSales(long id);
}

