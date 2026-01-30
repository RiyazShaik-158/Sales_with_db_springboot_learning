package com.learning.sales.dto.Item;

import jakarta.validation.constraints.NotNull;

public class ItemResponseDto extends ItemRequestDto{

    @NotNull
    private long id;

    public ItemResponseDto(long id, String name, String description) {
        super(name, description);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
