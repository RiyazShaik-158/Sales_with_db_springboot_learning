package com.learning.sales.repo;

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
}
