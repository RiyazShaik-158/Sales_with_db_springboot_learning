package com.learning.sales.service.Impl;

import com.learning.sales.dto.Item.ItemRequestDto;
import com.learning.sales.dto.Item.ItemResponseDto;
import com.learning.sales.entity.Item;
import com.learning.sales.exception.CustomerNotFoundError;
import com.learning.sales.repo.ItemRepo;
import com.learning.sales.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;

    public ItemServiceImpl(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public List<ItemResponseDto> getAllItems() {
         return itemRepo.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public ItemResponseDto getItemById(long id) {
        Item item = itemRepo.findById(id).orElseThrow(() -> new CustomerNotFoundError("Item not found with id: " + id));
        return mapToDto(item);
    }

    @Override
    public void addItem(ItemRequestDto itemRequestDto) {
        Item newItem = new Item();
        newItem.setName(itemRequestDto.getName());
        newItem.setDescription(itemRequestDto.getDescription());
        itemRepo.save(newItem);
    }

    @Override
    public void updateItem(long id, ItemRequestDto itemRequestDto) {
        Item requestedItem = itemRepo.findById(id).orElseThrow(() -> new CustomerNotFoundError("Item not found with id: " + id));
        requestedItem.setName(itemRequestDto.getName());
        requestedItem.setDescription(itemRequestDto.getDescription());
        itemRepo.save(requestedItem);
    }

    public ItemResponseDto mapToDto(Item item) {
        return new ItemResponseDto(item.getId(), item.getName(), item.getDescription());
    }
}
