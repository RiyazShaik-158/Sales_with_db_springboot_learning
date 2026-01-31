package com.learning.sales.service;

import com.learning.sales.dto.Item.ItemRequestDto;
import com.learning.sales.dto.Item.ItemResponseDto;

import java.util.List;

public interface ItemService {
    List<ItemResponseDto> getAllItems();

    ItemResponseDto getItemById(long id);

    void addItem(ItemRequestDto itemRequestDto);
}
