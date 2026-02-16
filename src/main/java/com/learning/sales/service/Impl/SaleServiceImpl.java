package com.learning.sales.service.Impl;

import com.learning.sales.dto.Sales.SalesByCustomerResponseDto;
import com.learning.sales.dto.Sales.SalesByItemResponseDto;
import com.learning.sales.dto.Sales.SalesRequestDto;
import com.learning.sales.dto.Sales.SalesResponseDto;
import com.learning.sales.entity.Sale;
import com.learning.sales.exception.CustomerNotFoundError;
import com.learning.sales.repo.CustomerRepo;
import com.learning.sales.repo.ItemRepo;
import com.learning.sales.repo.SalesRepo;
import com.learning.sales.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SalesRepo salesRepo;
    private final ItemRepo itemRepo;
    private final CustomerRepo customerRepo;

    public SaleServiceImpl(SalesRepo salesRepo, ItemRepo itemRepo, CustomerRepo customerRepo) {
        this.salesRepo = salesRepo;
        this.itemRepo = itemRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public SalesResponseDto getSalesById(long id) {
        return mapEntityToResponse(salesRepo.findById(id).orElseThrow(() -> new CustomerNotFoundError("Sales not found with id: " + id)));
    }

    @Override
    public List<SalesByItemResponseDto> getSalesByCustomerId(long customerId) {
        if(salesRepo.salesExistsByCustomerId(customerId)) {
            return salesRepo.getSalesByCustomerId(customerId);
        } else {
            throw new CustomerNotFoundError("Sales not found with customer id: " + customerId);
        }
    }

    @Override
    public List<SalesByItemResponseDto> getSalesByItemId(long itemId) {
        if(salesRepo.salesExistsByItemId(itemId)) {
            return salesRepo.getSalesByItemId(itemId);
        } else {
            throw new CustomerNotFoundError("Sales not found with item id: " + itemId);
        }
    }

    @Override
    public void addSales(SalesRequestDto salesRequestDto) {

        checkItemAndCustomerExistence(salesRequestDto);

        Sale newSale = new Sale();
        newSale.setCustomer_id(salesRequestDto.getCustomerId());
        newSale.setItem_id(salesRequestDto.getItemId());
        newSale.setDate(new Date());
        newSale.setQuantity(salesRequestDto.getQuantity());
        newSale.setPrice(salesRequestDto.getPrice());
        salesRepo.save(newSale);
    }

    @Override
    public void editSales(long id,SalesRequestDto salesRequestDto) {
        Sale requestedSale = salesRepo.findById(id).orElseThrow(() -> new CustomerNotFoundError("Sales not found with id: " + id));

        checkItemAndCustomerExistence(salesRequestDto);

        requestedSale.setCustomer_id(salesRequestDto.getCustomerId());
        requestedSale.setItem_id(salesRequestDto.getItemId());
        requestedSale.setDate(new Date());
        requestedSale.setQuantity(salesRequestDto.getQuantity());
        requestedSale.setPrice(salesRequestDto.getPrice());
        salesRepo.save(requestedSale);
    }

    @Override
    public void deleteSales(long id) {
        if(salesRepo.existsById(id)) {
            salesRepo.deleteById(id);
        } else {
            throw new CustomerNotFoundError("Sales not found with id: " + id);
        }

    }

    @Override
    public List<SalesByItemResponseDto> getAllSalesWithCustomerAndItem() {
        return salesRepo.getSalesWithCustomerAndItem();
    }

    public void checkItemAndCustomerExistence (SalesRequestDto salesRequestDto) {
        long requestedItemId = salesRequestDto.getItemId();
        long requestedCustomerId = salesRequestDto.getCustomerId();
        boolean itemExists = itemRepo.existsById(requestedItemId);
        boolean customerExists = customerRepo.existsById(requestedCustomerId);

        if(!itemExists) {
            throw new CustomerNotFoundError("Item not found with id: " + salesRequestDto.getItemId());
        }
        if(!customerExists) {
            throw new CustomerNotFoundError("Customer not found with id: " + salesRequestDto.getCustomerId());
        }
    }

    public static SalesResponseDto mapEntityToResponse(Sale sale) {
        return new SalesResponseDto(sale.getId(),sale.getItem_id(),sale.getCustomer_id(),sale.getDate(),sale.getQuantity(),sale.getPrice());
    }
}
