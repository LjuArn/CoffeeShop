package com.example.coffeeshop.domain.binding;

import com.example.coffeeshop.domain.entity.enums.CategoryNameEnum;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {

    private Long id;
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @Positive
    private BigDecimal price;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;
    @NotNull
    private CategoryNameEnum category;
    @Size(min = 5)
    private String description;

    public OrderAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderAddBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderAddBindingModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public OrderAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
