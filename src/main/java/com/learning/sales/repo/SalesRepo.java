package com.learning.sales.repo;

import com.learning.sales.dto.Sales.SalesByCustomerResponseDto;
import com.learning.sales.dto.Sales.SalesByItemResponseDto;
import com.learning.sales.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepo extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale s WHERE s.customer_id = :customerId")
    List<Sale> findByCustomerId(long customerId);

    @Query("SELECT COUNT(s) > 0 FROM Sale s WHERE s.customer_id = :customerId")
    Boolean salesExistsByCustomerId(long customerId);

    @Query("SELECT s FROM Sale s WHERE s.item_id = :itemId")
    List<Sale> findByItemId(long itemId);

    @Query("SELECT COUNT(s) > 0 FROM Sale s WHERE s.item_id = :item_id")
    Boolean salesExistsByItemId(long item_id);

    @Query(value = "SELECT c.name as customerName, i.name as itemName, s.quantity, s.price from item i left join sale s on i.id = s.item_id left join customer c on s.customer_id = c.id where i.id = :itemId", nativeQuery = true)
    List<SalesByItemResponseDto> getSalesByItemId(long itemId);

    @Query(value = "SELECT c.name as customerName, i.name as itemName, s.quantity, s.price from item i left join sale s on i.id = s.item_id left join customer c on s.customer_id = c.id where c.id = :customerId", nativeQuery = true)
    List<SalesByItemResponseDto> getSalesByCustomerId(long customerId);

    @Query(value = "select c.name as CustomerName, i.name as ItemName, s.quantity as Quantity, s.price as Price from customer c left join sale s on c.id = s.customer_id left join item i on s.item_id = i.id order by c.name", nativeQuery = true)
    List<SalesByItemResponseDto> getSalesWithCustomerAndItem();

}
