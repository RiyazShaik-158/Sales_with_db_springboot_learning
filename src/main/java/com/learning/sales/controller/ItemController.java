package com.learning.sales.controller;


import com.learning.sales.dto.Item.ItemRequestDto;
import com.learning.sales.dto.Item.ItemResponseDto;
import com.learning.sales.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@Tag(name = "Items Controller")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @Operation(summary = "Get All Items")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemResponseDto> getAllItems () {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Item By Id")
    @ResponseStatus(HttpStatus.OK)
    public ItemResponseDto getItemById(@PathVariable long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    @Operation(summary = "Add new Item")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody ItemRequestDto itemRequestDto) {
        itemService.addItem(itemRequestDto);
    }

}
