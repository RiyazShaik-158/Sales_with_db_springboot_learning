package com.learning.sales.repo;

import com.learning.sales.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
}
