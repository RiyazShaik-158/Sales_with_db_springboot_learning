package com.learning.sales.service.Impl;

import com.learning.sales.dto.Sales.SalesResponseDto;
import com.learning.sales.entity.Sale;
import com.learning.sales.exception.CustomerNotFoundError;
import com.learning.sales.repo.SalesRepo;
import com.learning.sales.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SalesRepo salesRepo;

    public SaleServiceImpl(SalesRepo salesRepo) {
        this.salesRepo = salesRepo;
    }

    @Override
    public List<SalesResponseDto> getAllSales() {
        return salesRepo.findAll().stream().map(SaleServiceImpl::mapEntityToResponse).toList();
    }

    @Override
    public SalesResponseDto getSalesById(long id) {
        return mapEntityToResponse(salesRepo.findById(id).orElseThrow(() -> new CustomerNotFoundError("Sales not found with id: " + id)));
    }

    @Override
    public List<SalesResponseDto> getSalesByCustomerId(long customerId) {
        if(salesRepo.salesExistsByCustomerId(customerId)) {
            return salesRepo.findByCustomerId(customerId).stream().map((SaleServiceImpl::mapEntityToResponse)).toList();
        } else {
            throw new CustomerNotFoundError("Sales not found with customer id: " + customerId);
        }
    }

    @Override
    public List<SalesResponseDto> getSalesByItemId(long itemId) {
        if(salesRepo.salesExistsByItemId(itemId)) {
            return salesRepo.findByItemId(itemId).stream().map((SaleServiceImpl::mapEntityToResponse)).toList();
        } else {
            throw new CustomerNotFoundError("Sales not found with item id: " + itemId);
        }
    }

    public static SalesResponseDto mapEntityToResponse(Sale sale) {
        return new SalesResponseDto(sale.getId(),sale.getItem_id(),sale.getCustomer_id(),sale.getDate(),sale.getQuantity(),sale.getPrice());
    }
}
